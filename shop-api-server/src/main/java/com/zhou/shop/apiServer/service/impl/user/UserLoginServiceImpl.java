package com.zhou.shop.apiServer.service.impl.user;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.dto.UserLoginDTO;
import com.zhou.shop.api.entity.user.User;
import com.zhou.shop.api.entity.user.UserLogin;
import com.zhou.shop.api.entity.user.UserRole;
import com.zhou.shop.api.vo.user.UserForgetVO;
import com.zhou.shop.api.vo.user.login.UserLoginUuidVO;
import com.zhou.shop.api.vo.user.login.UserLoginVO;
import com.zhou.shop.api.vo.user.register.UserRegisterVO;
import com.zhou.shop.apiServer.mapper.user.UserLoginMapper;
import com.zhou.shop.apiServer.mapper.user.UserMapper;
import com.zhou.shop.apiServer.mapper.user.UserRoleMapper;
import com.zhou.shop.apiServer.service.user.IUserLoginService;
import com.zhou.shop.common.BaseConstant;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.common.enums.RoleEnum;
import com.zhou.shop.common.enums.SourceEnum;
import com.zhou.shop.common.exception.CheckCodeErrorException;
import com.zhou.shop.common.exception.ShopException;
import com.zhou.shop.common.exception.UserAccountException;
import com.zhou.shop.oss.redis.RedisUtil;
import com.zhou.shop.util.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouxiong
 * @since 2022/3/14 17:41 @Description
 */
@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLogin>
        implements IUserLoginService {
    private final UserLoginMapper userLoginMapper;
    private final RedisUtil redisUtil;

    private final UserMapper userMapper;
    private final UserRoleMapper userRoleMapper;

    private final Logger log = LoggerFactory.getLogger(UserLoginServiceImpl.class);

    public UserLoginServiceImpl(
            UserLoginMapper userLoginMapper,
            RedisUtil redisUtil,
            UserMapper userMapper,
            UserRoleMapper userRoleMapper) {
        this.userLoginMapper = userLoginMapper;
        this.redisUtil = redisUtil;
        this.userMapper = userMapper;
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public RestObject<UserLoginDTO> login(UserLoginVO userLoginVo) {
        checkVerifyCode(userLoginVo.getUuid(), userLoginVo.getCheckCode());
        log.info("用户输入的账号：{}，密码：{}", userLoginVo.getUserAccount(), userLoginVo.getUserPassword());
        //如果三者全为空，则抛出异常
        if (StrUtil.isEmpty(userLoginVo.getUserAccount())
                && StrUtil.isEmpty(userLoginVo.getTel())
                && StrUtil.isEmpty(userLoginVo.getMail())) {
            throw new UserAccountException("账户、密码或验证码不能为空!");
        }
        // 验证账号密码
        final UserLoginDTO userLoginDTO = loginVerify(userLoginVo);
        Assert.notNull(userLoginDTO, "登录异常！");
        // sa-token生成token
        StpUtil.login(userLoginDTO.getUserId());
        final String token = StpUtil.getTokenValue();
        userLoginDTO.setToken(token);
        return RestResponse.makeOkRsp(userLoginDTO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RestObject<String> register(UserRegisterVO userRegisterVO) {
        checkVerifyCode(userRegisterVO.getUuid(), userRegisterVO.getCheckCode());

        if (StrUtil.isEmpty(userRegisterVO.getUserAccount())
                && StrUtil.isEmpty(userRegisterVO.getTel())
                && StrUtil.isEmpty(userRegisterVO.getMail())) {
            throw new UserAccountException("请输入有效账号!");
        }
        // todo 注册流程严重耦合，需待优化

        final UserRegisterVO encryptUrv = passwordEncrypt(userRegisterVO);

        // 雪花算法生成用户id
        final String userId = String.valueOf(new Snowflake().nextId());

        final User user = new User(userId);
        final UserLogin userLogin = new UserLogin(userId);
        final UserRole userRole = new UserRole(userId);
        // 默认角色 普通用户(2)
        userRole.setRoleId(RoleEnum.USER.getRoleId());
        // copy 到user对象
        BeanUtils.copyProperties(encryptUrv, user);
        // copy 到userLogin对象
        BeanUtils.copyProperties(encryptUrv, userLogin);
        // 查询数据库当前账号是否存在
        final UserLogin one =
                this.lambdaQuery().eq(UserLogin::getUserAccount, encryptUrv.getUserAccount()).one();
        if (!Objects.isNull(one)) {
            throw new UserAccountException("该账号已被注册，请勿重复注册！");
        }
        // 插入
        userMapper.insert(user);
        userLoginMapper.insert(userLogin);
        userRoleMapper.insert(userRole);
        return RestResponse.makeOkRsp("注册成功！");
    }

    /**
     * @param userForgetVO 前端传入对象
     * @return
     */
    @Override
    public RestObject<String> forgetPassword(UserForgetVO userForgetVO) {
        if (StrUtil.isNotBlank(userForgetVO.getMail())) {
            checkVerifyCode(userForgetVO.getUuid(), userForgetVO.getCheckCode());

            final UserLogin one =
                    this.lambdaQuery().eq(UserLogin::getUserAccount, userForgetVO.getMail()).one();
            final String passwordDecrypt = passwordDecrypt(one.getUserPassword());
            MailUtil.sendText(
                    userForgetVO.getMail(),
                    BaseConstant.MAIL_PASSWORD_SUBJECT,
                    BaseConstant.MAIL_PASSWORD_CONTENT + passwordDecrypt);
            return RestResponse.makeOkRsp("邮件已发送，请注意查收！");
        }
        throw new ShopException("请选择有效的验证方式！");
    }

    @Override
    public void verifyCode(@Valid UserLoginUuidVO userLoginUuidVO, HttpServletResponse response) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String code = RandomUtil.randomString(SourceEnum.numLetter.getSources(), 4);
            ImageUtil.createImage(code, baos);

            // 避免重复，将当前uuid键删除
            redisUtil.del(userLoginUuidVO.getUuid());
            // 将VerifyCode存入redis
            redisUtil.setex(userLoginUuidVO.getUuid(), code, 1L, TimeUnit.HOURS);

            // 设置响应头
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Access-Control-Allow-Origin", "true");

            // 在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);

            // 设置响应内容类型
            response.setContentType("image/jpeg");

            response.getOutputStream().write(baos.toByteArray());
            response.getOutputStream().flush();
            baos.close();
        } catch (IOException e) {
            throw new ShopException(e.getMessage());
        }
    }

    /**
     * 通过邮箱获取验证码
     *
     * @param mail 邮箱号
     */
    @Override
    public void mailVerifyCode(String uuid, String mail) {
        // 先删除，万一有重复的
        redisUtil.del(uuid);
        String mailVerifyCode = RandomUtil.randomString(SourceEnum.num.getSources(), 6);
        // 写入redis中，为期一个小时
        redisUtil.setex(uuid, mailVerifyCode, 1L, TimeUnit.HOURS);
        MailUtil.sendText(
                mail,
                BaseConstant.MAIL_VERIFY_CODE_SUBJECT,
                BaseConstant.MAIL_VERIFY_CODE_CONTENT + mailVerifyCode);
    }

    /**
     * 验证码校验
     *
     * @param uuid uuid
     * @param userCode 用户输入的
     */
    private void checkVerifyCode(String uuid, String userCode) {
        // 获取验证码
        String redisCode = (String) redisUtil.get(uuid);
        // 获取前端输入的验证码并将小写字母转成大写字母
        userCode = userCode.toUpperCase();

        log.info("redis验证码：{}，用户输入验证码：{}", redisCode, userCode);
        if (!StrUtil.equals(redisCode, userCode)) {
            throw new CheckCodeErrorException("验证码输入错误！");
        }
    }

    /**
     * 登录验证方法
     *
     * @param userLoginVo 前端传入对象
     * @return 验证成功与否
     */
    private UserLoginDTO loginVerify(UserLoginVO userLoginVo) {
        // 账号密码登录方式
        if (StrUtil.isNotBlank(userLoginVo.getUserAccount())) {
            return userQuery(userLoginVo.getUserAccount(), userLoginVo.getUserPassword());
        }

        // 邮件登录方式
        if (StrUtil.isNotBlank(userLoginVo.getMail())) {
            return userQuery(userLoginVo.getMail(), userLoginVo.getUserPassword());
        }
        return null;
    }

    /**
     * 用户查询
     *
     * @param account 登录凭证
     * @param password 登录密码
     * @return 查询出的用户登录实体
     */
    private UserLoginDTO userQuery(String account, String password) {
        final UserLoginDTO userLoginDTO = new UserLoginDTO();
        final UserLogin userLogin =
                this.lambdaQuery()
                        .eq(UserLogin::getUserAccount, account)
                        .eq(
                                UserLogin::getUserPassword,
                                SaSecureUtil.aesEncrypt(BaseConstant.AES_KEY, password))
                        .one();
        if (Objects.isNull(userLogin)) {
            throw new UserAccountException("用户凭证、密码有误，请重新输入！");
        }
        final User user = userMapper.selectById(userLogin.getUserId());
        userLoginDTO.setUserId(userLogin.getUserId());
        userLoginDTO.setUserPicture(user.getUserPicture());
        BeanUtils.copyProperties(userLogin, userLoginDTO);
        return userLoginDTO;
    }

    /**
     * 密码加密
     *
     * <p>加密流程：后端将前端传入的密码字符串加盐后用默认钥匙对称加密一次， 加密的钥匙随机生成并写入在数据库中， 加密的钥匙写入数据库的时候用写死的钥匙再次加密一次，
     * 然后后端再用MD5加密存入数据库。（未使用）
     *
     * <p>使用对称加密一次即可
     *
     * @param userRegisterVO 前端传入注册的对象
     * @return 密码加密后的注册对象
     */
    private UserRegisterVO passwordEncrypt(UserRegisterVO userRegisterVO) {
        final String encryptPassword =
                SaSecureUtil.aesEncrypt(BaseConstant.AES_KEY, userRegisterVO.getUserPassword());
        userRegisterVO.setUserPassword(encryptPassword);
        return userRegisterVO;
    }

    /**
     * 密码解密
     *
     * @param password 密码密文
     * @return 密码明文
     */
    private String passwordDecrypt(String password) {
        return SaSecureUtil.aesDecrypt(BaseConstant.AES_KEY, password);
    }
}

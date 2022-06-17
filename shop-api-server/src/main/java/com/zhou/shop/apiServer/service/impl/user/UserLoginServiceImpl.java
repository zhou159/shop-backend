package com.zhou.shop.apiServer.service.impl.user;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.dto.UserLoginDTO;
import com.zhou.shop.api.entity.user.User;
import com.zhou.shop.api.entity.user.UserLogin;
import com.zhou.shop.api.entity.user.UserRole;
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
import com.zhou.shop.common.exception.ShopException;
import com.zhou.shop.common.exception.UserAccountException;
import com.zhou.shop.oss.redis.RedisUtil;
import com.zhou.shop.util.ImageUtil;
import com.zhou.shop.util.RandomUtil;
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
    // private final JwtUtil jwtUtil;

    private final Logger log = LoggerFactory.getLogger(UserLoginServiceImpl.class);

    public UserLoginServiceImpl(
            UserLoginMapper userLoginMapper,
            RedisUtil redisUtil, /*, JwtUtil jwtUtil*/
            UserMapper userMapper,
            UserRoleMapper userRoleMapper) {
        this.userLoginMapper = userLoginMapper;
        this.redisUtil = redisUtil;
        // this.jwtUtil = jwtUtil;
        this.userMapper = userMapper;
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public RestObject<UserLoginDTO> login(UserLoginVO userLoginVo) {
        String redisCode = (String) redisUtil.get(userLoginVo.getUuid());
        String userCode = userLoginVo.getCheckCode().toUpperCase();
        log.info("redis验证码：{}，用户输入验证码：{}", redisCode, userCode);
        log.info("用户输入的账号：{}，密码：{}", userLoginVo.getUserAccount(), userLoginVo.getUserPassword());
        // TODO NotBlank 注解失效 待解决 先手动判空（已解决）
        // =====
        //        if (StrUtil.isBlank(userLoginVo.getUuid())) {
        //            throw new ObjectFieldEmptyException("uuid不能为空！");
        //        }
        // =====

        //如果三者全为空，则抛出异常
        if (StrUtil.isEmpty(userLoginVo.getUserAccount())
                && StrUtil.isEmpty(userLoginVo.getTel())
                && StrUtil.isEmpty(userLoginVo.getMail())) {
            throw new UserAccountException("账户、密码或验证码不能为空!");
        }

        //验证码正确
        if (userCode.equals(redisCode)) {
            // 验证账号密码
            final UserLoginDTO userLoginDTO = loginVerify(userLoginVo);
            Assert.notNull(userLoginDTO, "登录异常！");

            // jwtUtil生成token
            // final String token = jwtUtil.getToken(userLoginDTO,userLoginVo.getUserPassword());

            // sa-token生成token
            StpUtil.login(userLoginDTO.getUserId());
            final String token = StpUtil.getTokenValue();
            userLoginDTO.setToken(token);
            return RestResponse.makeOkRsp(userLoginDTO);
        } else {
            throw new UserAccountException("验证码错误!");
        }
    }

    @Transactional
    @Override
    public RestObject<String> register(UserRegisterVO userRegisterVO) {
        // 获取验证码
        String redisCode = (String) redisUtil.get(userRegisterVO.getUuid());
        // 获取前端输入的验证码并将小写字母转成大写字母
        String userCode = userRegisterVO.getCheckCode().toUpperCase();

        log.info("redis验证码：{}，用户输入验证码：{}", redisCode, userCode);

        if (StrUtil.isEmpty(userRegisterVO.getUserAccount())
                && StrUtil.isEmpty(userRegisterVO.getTel())
                && StrUtil.isEmpty(userRegisterVO.getMail())) {
            throw new UserAccountException("请输入有效账号!");
        }

        if (userCode.equals(redisCode)) {
            final String passwordEncrypt = passwordEncrypt(userRegisterVO.getUserPassword());
            userRegisterVO.setUserPassword(passwordEncrypt);

            final String userId = String.valueOf(new Snowflake().nextId());

            final User user = new User(userId);
            final UserLogin userLogin = new UserLogin(userId);
            final UserRole userRole = new UserRole(userId);
            //默认角色 普通用户(2)
            userRole.setRoleId(RoleEnum.USER.getRoleId());

            BeanUtils.copyProperties(userRegisterVO, user);
            BeanUtils.copyProperties(userRegisterVO, userLogin);

            //查询数据库当前账号是否存在
            final UserLogin one =
                    this.lambdaQuery()
                            .eq(UserLogin::getUserAccount, userRegisterVO.getUserAccount())
                            .one();
            if (!Objects.isNull(one)) {
                throw new UserAccountException("该账号已被注册，请勿重复注册！");
            }

            //插入
            userMapper.insert(user);
            userLoginMapper.insert(userLogin);
            userRoleMapper.insert(userRole);

            return RestResponse.makeOkRsp("注册成功！");
        }
        throw new UserAccountException("验证码不正确，请重新输入!");
    }

    @Override
    public void verifyCode(@Valid UserLoginUuidVO userLoginUuidVO, HttpServletResponse response) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String code = RandomUtil.createRandom(4, SourceEnum.numLetter, SourceEnum.numLetter.getLength());
            ImageUtil.createImage(code, baos);

            // TODO NotBlank 注解失效 待解决 先手动判空
            //            if (StrUtil.isBlank(userLoginUuidVO.getUuid())) {
            //                throw new ObjectFieldEmptyException("uuid不能为空！");
            //            }
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
        String mailVerifyCode =
                RandomUtil.createRandom(6, SourceEnum.num, SourceEnum.num.getLength());
        // 写入redis中，为期一个小时
        redisUtil.setex(uuid, mailVerifyCode, 1L, TimeUnit.HOURS);
        MailUtil.sendText(mail, "登录验证码", "【SHOP】您的登录验证码为：" + mailVerifyCode);
    }

    /**
     * 登录验证方法
     *
     * @param userLoginVo 前端传入对象
     * @return 验证成功与否
     */
    private UserLoginDTO loginVerify(UserLoginVO userLoginVo) {
        // TODO 账户校验
        // 账号密码登录方式
        if (StrUtil.isNotBlank(userLoginVo.getUserAccount())) {
            final UserLoginDTO userLoginDTO =
                    userQuery(userLoginVo.getUserAccount(), userLoginVo.getUserPassword());
            return userLoginDTO;
        }

        // 邮件登录方式
        if (StrUtil.isNotBlank(userLoginVo.getMail())) {
            final UserLoginDTO userLoginDTO =
                    userQuery(userLoginVo.getMail(), userLoginVo.getUserPassword());
            return userLoginDTO;
        }
        return null;
    }

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
            throw new UserAccountException("账户、密码错误，请重新输入！");
        }
        userLoginDTO.setUserId(userLogin.getUserId());
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
     * @param password 密码明文
     * @return 密码密文
     */
    private String passwordEncrypt(String password) {
        return SaSecureUtil.aesEncrypt(BaseConstant.AES_KEY, password);
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

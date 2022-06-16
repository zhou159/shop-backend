package com.zhou.shop.apiServer.service.impl.user;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.dto.UserLoginDTO;
import com.zhou.shop.api.entity.user.UserLogin;
import com.zhou.shop.api.vo.user.login.UserLoginUuidVO;
import com.zhou.shop.api.vo.user.login.UserLoginVO;
import com.zhou.shop.apiServer.mapper.user.UserLoginMapper;
import com.zhou.shop.apiServer.service.user.IUserLoginService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.common.enums.Source;
import com.zhou.shop.common.exception.ShopException;
import com.zhou.shop.common.exception.UserAccountException;
import com.zhou.shop.oss.redis.RedisUtil;
import com.zhou.shop.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.zhou.shop.util.RandomUtil.createImage;

/**
 * @author zhouxiong
 * @since 2022/3/14 17:41 @Description
 */
@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLogin>
        implements IUserLoginService {
    private final UserLoginMapper userLoginMapper;
    private final RedisUtil redisUtil;
    // private final JwtUtil jwtUtil;

    private final Logger log = LoggerFactory.getLogger(UserLoginServiceImpl.class);

    public UserLoginServiceImpl(
            UserLoginMapper userLoginMapper, RedisUtil redisUtil /*, JwtUtil jwtUtil*/) {
        this.userLoginMapper = userLoginMapper;
        this.redisUtil = redisUtil;
        // this.jwtUtil = jwtUtil;
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

    @Override
    public RestObject<String> registerUsername(UserLoginVO userLoginVo) {
        // 获取验证码，验证码来源另一个接口
        String redisCode = (String) redisUtil.get(userLoginVo.getUuid());

        // 获取前端输入的验证码并将小写字母转成大写字母
        String userCode = userLoginVo.getCheckCode().toUpperCase();
        if ("".equals(userLoginVo.getUserAccount())
                || "".equals(userLoginVo.getUserPassword())
                || "".equals(userCode)) {
            throw new UserAccountException("账户、密码或验证码不能为空!");
        } else {
            if (userCode.equals(redisCode)) {
                // 通过前端传入的数据到数据库查询是否存在用户
                QueryWrapper<UserLogin> userLoginQueryWrapper = new QueryWrapper<>();
                UserLogin user =
                        userLoginMapper.selectOne(
                                userLoginQueryWrapper.eq(
                                        "user_account", userLoginVo.getUserAccount()));
                if (user != null) {
                    throw new UserAccountException("该账号已被注册!");
                } else {
                    //                    //随机生成10位数昵称
                    //                    String nickName = RandomUtil.createRandom(10,
                    // Source.symbolNumLetter,Source.symbolNumLetter.getSources().length());
                    //                    //查询该昵称是否存在
                    //                    User user1 = userService.queryByNickName(nickName);
                    //                    //如果存在，循环随机生成
                    //                    while (user1!=null){
                    //                        nickName =
                    // RandomUtil.createRandom(10,Source.symbolNumLetter,Source.symbolNumLetter.getSources().length());
                    //                        user1 = userService.queryByNickName(nickName);
                    //                    }
                    //                    userVo.setNickname(nickName);
                    //                    //注册事务
                    //                    userService.registerUsername(userVo);
                    return RestResponse.makeOkRsp("注册成功!");
                }
            } else {
                throw new UserAccountException("验证码不正确，请重新输入!");
            }
        }
    }

    @Override
    public void verifyCode(@Valid UserLoginUuidVO userLoginUuidVO, HttpServletResponse response) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String code =
                    RandomUtil.createRandom(
                            4, Source.numLetter, Source.numLetter.getSources().length());
            createImage(code, baos);

            // TODO NotBlank 注解失效 待解决 先手动判空
            //            if (StrUtil.isBlank(userLoginUuidVO.getUuid())) {
            //                throw new ObjectFieldEmptyException("uuid不能为空！");
            //            }
            // 避免重复，将当前uuid键删除
            redisUtil.del(userLoginUuidVO.getUuid());
            // 将VerifyCode存入redis
            redisUtil.setex(userLoginUuidVO.getUuid(), code, 1L, TimeUnit.DAYS);

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
                RandomUtil.createRandom(6, Source.num, Source.num.getSources().length());
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
                    loginQuery(userLoginVo.getUserAccount(), userLoginVo.getUserPassword());
            return userLoginDTO;
        }

        // 邮件登录方式
        if (StrUtil.isNotBlank(userLoginVo.getMail())) {
            final UserLoginDTO userLoginDTO =
                    loginQuery(userLoginVo.getMail(), userLoginVo.getUserPassword());
            return userLoginDTO;
        }
        return null;
    }

    private UserLoginDTO loginQuery(String account, String password) {
        final UserLoginDTO userLoginDTO = new UserLoginDTO();
        final UserLogin userLogin =
                this.lambdaQuery()
                        .eq(UserLogin::getUserAccount, account)
                        .eq(UserLogin::getUserPassword, password)
                        .one();
        if (Objects.isNull(userLogin)) {
            throw new UserAccountException("账户、密码错误，请重新输入！");
        }
        userLoginDTO.setUserId(userLogin.getUserId());
        BeanUtils.copyProperties(userLogin, userLoginDTO);
        return userLoginDTO;
    }
}

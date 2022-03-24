package com.zhou.shop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhou.shop.entity.UserLogin;
import com.zhou.shop.exception.UserAccountException;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IUserLoginService;
import com.zhou.shop.vo.UserLoginVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/userLogin")
public class UserLoginController {

    private final IUserLoginService userLoginService;

    public UserLoginController(IUserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @PostMapping("/login")
    public RestObject<String> login(@RequestBody UserLoginVo userLoginVo, HttpSession session) {

        Object code = session.getAttribute("VerifyCode");
        String userCode = userLoginVo.getCheckCode().toUpperCase();
        if ("".equals(userLoginVo.getUsername())
                || "".equals(userLoginVo.getPassword())
                || "".equals(userCode)) {
            throw new UserAccountException("账户、密码或验证码不能为空!");
        }
        if (userCode.equals(code)) {
            QueryWrapper<UserLogin> userLoginQueryWrapper = new QueryWrapper<>();
            UserLogin user =
                    userLoginService.getOne(
                            userLoginQueryWrapper
                                    .eq("user_account", userLoginVo.getUsername())
                                    .eq("user_password", userLoginVo.getPassword()));
            if (user == null) {
                throw new UserAccountException("账户、密码错误!");
            }
            return RestResponse.makeOkRsp("登录成功!");
        } else {
            throw new UserAccountException("验证码错误!");
        }
    }

    @ApiOperation("通过账户方式注册")
    @PostMapping("/registerUsername")
    public RestObject<String> registerUsername(
            @RequestBody UserLoginVo userVo, HttpSession session) {
        // 获取验证码，验证码来源另一个接口
        Object code = session.getAttribute("VerifyCode");

        // 获取前端输入的验证码并将小写字母转成大写字母
        String userCode = userVo.getCheckCode().toUpperCase();
        if ("".equals(userVo.getUsername())
                || "".equals(userVo.getPassword())
                || "".equals(userCode)) {
            throw new UserAccountException("账户、密码或验证码不能为空!");
        } else {
            if (userCode.equals(code)) {
                // 通过前端传入的数据到数据库查询是否存在用户
                QueryWrapper<UserLogin> userLoginQueryWrapper = new QueryWrapper<>();
                UserLogin user =
                        userLoginService.getOne(
                                userLoginQueryWrapper.eq("user_account", userVo.getUsername()));
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
}

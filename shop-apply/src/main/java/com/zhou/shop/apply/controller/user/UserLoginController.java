package com.zhou.shop.apply.controller.user;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.Snowflake;
import com.zhou.shop.api.dto.UserLoginDTO;
import com.zhou.shop.api.vo.user.UserForgetPasswordVO;
import com.zhou.shop.api.vo.user.UserModifyPasswordVO;
import com.zhou.shop.api.vo.user.login.UserLoginUuidVO;
import com.zhou.shop.api.vo.user.login.UserLoginVO;
import com.zhou.shop.api.vo.user.register.UserRegisterVO;
import com.zhou.shop.apiServer.service.user.IUserLoginService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/userLogin")
@Api(tags = "用户登录")
public class UserLoginController {

    private final IUserLoginService userLoginService;

    public UserLoginController(IUserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    /**
     * 获取唯一标识,绑定验证码
     *
     * @return uuid
     */
    @ApiOperation(value = "uuid")
    @GetMapping("/uuid")
    public RestObject<String> obtainUuid() {
        final String uuid = String.valueOf(new Snowflake().nextId());
        return RestResponse.makeOkRsp(uuid);
    }

    @ApiOperation(value = "图形验证码")
    @GetMapping("/verifyCode")
    public void verifyCode(
            @Valid UserLoginUuidVO userLoginUuidVO, HttpServletResponse response) {
        userLoginService.verifyCode(userLoginUuidVO, response);
    }

    @ApiOperation(value = "邮箱验证码")
    @GetMapping("/mailVerifyCode")
    public RestObject<String> mailVerifyCode(String uuid, String mail) {
        userLoginService.mailVerifyCode(uuid, mail);
        return RestResponse.makeOkRsp("发送成功，请注意查看！");
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public RestObject<UserLoginDTO> login(@Valid @RequestBody UserLoginVO userLoginVo, HttpServletRequest request) {
        return userLoginService.login(userLoginVo,request);
    }

    @ApiOperation("用户注销登录")
    @GetMapping("/loginOut")
    public void loginOut() {
        StpUtil.logout();
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public RestObject<String> register(@Valid @RequestBody UserRegisterVO userRegisterVO) {
        return userLoginService.register(userRegisterVO);
    }

    @ApiOperation("忘记密码")
    @PostMapping("/forgetPassword")
    public RestObject<String> forgetPassword(@Valid @RequestBody UserForgetPasswordVO userForgetPasswordVO) {
        return userLoginService.forgetPassword(userForgetPasswordVO);
    }

    @ApiOperation("修改密码")
    @PostMapping("/modifyPassword")
    public RestObject<String> modifyPassword(@Valid @RequestBody UserModifyPasswordVO userModifyPasswordVO) {
        return userLoginService.modifyPassword(userModifyPasswordVO);
    }
}

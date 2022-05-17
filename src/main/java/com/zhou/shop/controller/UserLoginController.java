package com.zhou.shop.controller;

import com.zhou.shop.result.RestObject;
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
        return userLoginService.login(userLoginVo, session);
    }

    @ApiOperation("通过账户方式注册")
    @PostMapping("/registerUsername")
    public RestObject<String> registerUsername(
            @RequestBody UserLoginVo userVo, HttpSession session) {
        return userLoginService.registerUsername(userVo, session);
    }
}

package com.zhou.shop.apply.controller.user;

import cn.hutool.core.lang.Snowflake;
import com.zhou.shop.api.dto.UserLoginDTO;
import com.zhou.shop.api.vo.user.login.UserLoginUuidVO;
import com.zhou.shop.api.vo.user.login.UserLoginVO;
import com.zhou.shop.apiServer.service.user.IUserLoginService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
     * @return
     */
    @ApiOperation(value = "uuid")
    @GetMapping("/uuid")
    public RestObject<String> obtainUuid() {
        // hutool生成的雪花算法
        final String uuid = String.valueOf(new Snowflake().nextId());
        return RestResponse.makeOkRsp(uuid);
    }

    @ApiOperation(value = "图形验证码")
    @PostMapping("/verifyCode")
    public void verifyCode(
            @Valid @RequestBody UserLoginUuidVO userLoginUuidVO, HttpServletResponse response) {
        // TODO NotBlank 注解失效 待解决 先手动判空
        userLoginService.verifyCode(userLoginUuidVO, response);
    }

    @ApiOperation(value = "邮箱验证码")
    @GetMapping("/mailVerifyCode")
    public RestObject<String> mailVerifyCode(String uuid, String mail) {
        userLoginService.mailVerifyCode(uuid, mail);
        return RestResponse.makeOkRsp("发送成功，请注意查看！");
    }

    @PostMapping("/login")
    public RestObject<UserLoginDTO> login(@Valid @RequestBody UserLoginVO userLoginVo) {
        return userLoginService.login(userLoginVo);
    }

    @ApiOperation("通过账户方式注册")
    @PostMapping("/registerUsername")
    public RestObject<String> registerUsername(@RequestBody UserLoginVO userVo) {
        return userLoginService.registerUsername(userVo);
    }
}

package com.zhou.shop.apply.controller.user;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.zhou.shop.api.entity.user.User;
import com.zhou.shop.apiServer.service.user.IUserService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前端控制器
 *
 * @author 周雄
 * @since 2021-06-24
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController {

    final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @SaCheckRole("admin")
    @ApiOperation("新增用户[需更改逻辑]")
    @PostMapping("/createUser")
    public RestObject<String> createUser(@RequestBody User user) {
        return iUserService.createUser(user);
    }

    @SaCheckLogin
    @ApiOperation("按id查询用户")
    @GetMapping("/retrieveByUserId/{userId}")
    public RestObject<User> retrieveByUserId(@PathVariable String userId) {
        return iUserService.retrieveByUserId(userId);
    }

    @SaCheckRole("superAdmin")
    @ApiOperation("查询全部用户信息")
    @GetMapping("/admin/retrieveAllUser")
    public RestObject<List<User>> retrieveAllUser() {
        return iUserService.retrieveAllUser();
    }

    @SaCheckLogin
    @ApiOperation("按id修改用户")
    @PostMapping("/updateUserByUserId")
    public RestObject<String> updateUserByUserId(@RequestBody User user) {
        return iUserService.updateUserByUserId(user);
    }

    @SaCheckRole("superAdmin")
    @ApiOperation("按id删除用户")
    @PostMapping("/admin/deleteByUserId/{userId}")
    public RestObject<String> deleteUserById(@PathVariable String userId) {
        return iUserService.deleteUserById(userId);
    }

    //绑定手机号[使用可能性不大，因为要钱]

    //绑定邮箱

    //更改手机号[]

    //更改邮箱
}

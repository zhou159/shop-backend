package com.zhou.shop.apply.controller.user;

import com.zhou.shop.api.entity.user.User;
import com.zhou.shop.apiServer.service.user.IUserService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 前端控制器
 *
 * @author 周雄
 * @since 2021-06-24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @ApiOperation("新增用户")
    @PostMapping("/createUser")
    public RestObject<String> createUser(@RequestBody User user) {
        return iUserService.createUser(user);
    }

    @ApiOperation("按id查询用户")
    @GetMapping("/retrieveByUserId/{userId}")
    public RestObject<User> retrieveByUserId(@PathVariable String userId) {
        return iUserService.retrieveByUserId(userId);
    }

    @ApiOperation("查询全部用户信息")
    @GetMapping("/retrieveAllUser")
    public RestObject<List<User>> retrieveAllUser() {
        return iUserService.retrieveAllUser();
    }

    @ApiOperation("按id修改用户")
    @PostMapping("/updateUserByUserId/{userId}")
    public RestObject<String> updateUserByUserId(@PathVariable String userId, @RequestBody User user) {
        return iUserService.updateUserByUserId(userId, user);
    }

    @ApiOperation("按id删除用户")
    @PostMapping("/deleteByUserId/{userId}")
    public RestObject<String> deleteUserById(@PathVariable String userId) {
        return iUserService.deleteUserById(userId);
    }

    @ApiOperation(value = "图形验证码")
    @GetMapping("/verifyCode")
    public void verifyCode(HttpSession session, HttpServletResponse response) {
        iUserService.verifyCode(session, response);
    }
}

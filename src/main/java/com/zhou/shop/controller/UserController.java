package com.zhou.shop.controller;

import com.zhou.shop.entity.User;
import com.zhou.shop.enums.LogStatus;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IUserService;
import com.zhou.shop.util.LogUtil;
import com.zhou.shop.util.MinioUtil;
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
public class UserController {

    final IUserService iUserService;
    final LogUtil logUtil;
    final MinioUtil minioUtil;

    public UserController(IUserService iUserService, MinioUtil minioUtil, LogUtil logUtil) {
        this.iUserService = iUserService;
        this.minioUtil = minioUtil;
        this.logUtil = logUtil;
    }

    @ApiOperation("新增用户")
    @PostMapping("/createUser")
    public RestObject<String> createUser(@RequestBody User user) {
        boolean save = iUserService.save(user);
        if (save) {
            logUtil.log("新增用户成功", LogStatus.INFO.info);
            return RestResponse.makeOkRsp("新增成功！");
        }
        logUtil.log("新增用户出现异常", LogStatus.INFO.info);
        return RestResponse.makeErrRsp("新增失败！");
    }

    @ApiOperation("按id查询用户")
    @GetMapping("/retrieveByUserId/{userId}")
    public RestObject<User> retrieveByUserId(@PathVariable String userId) {
        User user = iUserService.getById(userId);
        logUtil.log("查询了用户信息，用户ID：" + userId, LogStatus.INFO.info);
        return RestResponse.makeOkRsp(user);
    }

    @ApiOperation("查询全部用户信息")
    @GetMapping("/retrieveAllUser")
    public RestObject<List<User>> retrieveAllUser() {
        List<User> list = iUserService.list();
        logUtil.log("查询了全部用户信息", LogStatus.INFO.info);
        return RestResponse.makeOkRsp(list);
    }

    @ApiOperation("按id修改用户")
    @PostMapping("/updateUserByUserId/{userId}")
    public RestObject<String> updateUserByUserId(@PathVariable String userId, @RequestBody User user) {
        user.setUserId(userId);
        boolean b = iUserService.updateById(user);
        if (b) {
            logUtil.log("成功修改了用户信息，用户ID：" + userId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("修改成功！");
        }
        logUtil.log("修改用户信息时失败，用户ID：" + userId, LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("修改失败！");
    }

    @ApiOperation("按id删除用户")
    @PostMapping("/deleteByUserId/{userId}")
    public RestObject<String> deleteUserById(@PathVariable String userId) {
        boolean b = iUserService.removeById(userId);
        if (b) {
            logUtil.log("成功删除了用户信息，用户ID：" + userId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("删除成功！");
        }
        logUtil.log("删除用户信息时失败，用户ID：" + userId, LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("删除失败！");
    }
}

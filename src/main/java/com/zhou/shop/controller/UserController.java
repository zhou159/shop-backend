package com.zhou.shop.controller;

import com.zhou.shop.entity.User;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 周雄
 * @since 2021-06-24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/createUser")
    public RestObject<String> createUser(@RequestBody User user){
        boolean save = iUserService.save(user);
        if (save){
            return RestResponse.makeOKRsp("新增成功！");
        }else {
            return RestResponse.makeErrRsp("新增成功！");
        }
    }

    @GetMapping("/retrieveByUserId/{userId}")
    public RestObject<User> retrieveByUserId(@PathVariable int userId){
        User user = iUserService.getById(userId);
        return RestResponse.makeOKRsp(user);
    }

    @GetMapping("/retrieveAllUser")
    public RestObject<List<User>> retrieveAllUser (){
        List<User> list = iUserService.list();
        return RestResponse.makeOKRsp(list);
    }

    @PostMapping("/updateUserByUserId/{userId}")
    public RestObject<String> updateUserByUserId(@PathVariable int userId,@RequestBody User user){
        user.setUserId(userId);
        boolean b = iUserService.updateById(user);
        if (b){
            return RestResponse.makeOKRsp("修改成功！");
        }else {
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @PostMapping("/deleteByUserId/{userId}")
    public RestObject<String> deleteUserById(@PathVariable int userId){
        boolean b = iUserService.removeById(userId);
        if (b){
            return RestResponse.makeOKRsp("删除成功！");
        }else {
            return RestResponse.makeErrRsp("删除失败！");
        }
    }
}

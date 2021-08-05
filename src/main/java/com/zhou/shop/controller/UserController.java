package com.zhou.shop.controller;

import com.zhou.shop.entity.User;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IUserService;
import com.zhou.shop.util.MinioUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    final IUserService iUserService;

    final MinioUtil minioUtil;

    public UserController(IUserService iUserService, MinioUtil minioUtil) {
        this.iUserService = iUserService;
        this.minioUtil = minioUtil;
    }

    @PostMapping("/createUser")
    public RestObject<String> createUser(@RequestBody User user){
        boolean save = iUserService.save(user);
        if (save){
            return RestResponse.makeOkRsp("新增成功！");
        }else {
            return RestResponse.makeErrRsp("新增成功！");
        }
    }

    @GetMapping("/retrieveByUserId/{userId}")
    public RestObject<User> retrieveByUserId(@PathVariable int userId){
        User user = iUserService.getById(userId);
        return RestResponse.makeOkRsp(user);
    }

    @GetMapping("/retrieveAllUser")
    public RestObject<List<User>> retrieveAllUser (){
        List<User> list = iUserService.list();
        return RestResponse.makeOkRsp(list);
    }

    @PostMapping("/updateUserByUserId/{userId}")
    public RestObject<String> updateUserByUserId(@PathVariable int userId,@RequestBody User user){
        user.setUserId(userId);
        boolean b = iUserService.updateById(user);
        if (b){
            return RestResponse.makeOkRsp("修改成功！");
        }else {
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @PostMapping("/deleteByUserId/{userId}")
    public RestObject<String> deleteUserById(@PathVariable int userId){
        boolean b = iUserService.removeById(userId);
        if (b){
            return RestResponse.makeOkRsp("删除成功！");
        }else {
            return RestResponse.makeErrRsp("删除失败！");
        }
    }

    @PostMapping("/minio")
    public RestObject<String> test(MultipartFile file){
        String test = minioUtil.upload(file, "test");
        return RestResponse.makeOkRsp(test);
    }
}

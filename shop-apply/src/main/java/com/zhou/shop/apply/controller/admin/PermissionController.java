package com.zhou.shop.apply.controller.admin;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zhou.shop.api.entity.user.Permission;
import com.zhou.shop.api.vo.admin.PermissionAddVO;
import com.zhou.shop.apiServer.service.admin.IPermissionService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限和功能菜单目前暂时混为一谈
 *
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/6 9:11
 */
@SaCheckRole("superAdmin")
@Api(tags = "权限")
@RestController
@RequestMapping("/permission")
public class PermissionController {
    private final IPermissionService permissionService;

    public PermissionController(IPermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @ApiOperation("查询所有权限")
    @GetMapping("/retrieveAllPermission")
    public RestObject<List<Permission>> retrieveAllPermission() {
        return permissionService.retrieveAllPermission();
    }

    @ApiOperation("修改权限")
    @PostMapping("/updatePermission")
    public RestObject<String> updatePermission(@RequestBody Permission permission) {
        return permissionService.updatePermission(permission);
    }

    @ApiOperation("锁定权限")
    @GetMapping("/lockPermission/{permissionId}")
    public RestObject<String> lockPermission(@PathVariable("permissionId") String permissionId) {
        return permissionService.lockPermission(permissionId);
    }

    @ApiOperation("解锁权限")
    @GetMapping("/unlLockPermission/{permissionId}")
    public RestObject<String> unlLockPermission(@PathVariable("permissionId") String permissionId) {
        return permissionService.unlLockPermission(permissionId);
    }

    @ApiOperation("新增权限")
    @PostMapping("/createPermission")
    public RestObject<String> createPermission(@RequestBody PermissionAddVO permissionAddVO) {
        return permissionService.createPermission(permissionAddVO);
    }

    @ApiOperation("删除权限")
    @PostMapping("/deletePermission/{permissionId}")
    public RestObject<String> deletePermission(@PathVariable("permissionId") String permissionId) {
        return permissionService.deletePermission(permissionId);
    }
}

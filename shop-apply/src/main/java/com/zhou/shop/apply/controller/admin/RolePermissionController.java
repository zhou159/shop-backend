package com.zhou.shop.apply.controller.admin;

import com.zhou.shop.apiServer.service.admin.IRolePermissionService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/21 16:55
 */
@Api(tags = "角色权限")
@RestController
@RequestMapping("/rolePermission")
public class RolePermissionController {
    private final IRolePermissionService rolePermissionService;

    public RolePermissionController(IRolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @ApiOperation("根据id删除角色权限")
    @PostMapping("/deleteByRolePermissionId/{rolePermissionId}")
    public RestObject<String> deleteByRolePermissionId(@PathVariable String rolePermissionId) {
        return rolePermissionService.deleteRolePermissionById(rolePermissionId);
    }

    @ApiOperation("根据角色id和权限id删除角色权限")
    @PostMapping("/deleteByTwoId")
    public RestObject<String> deleteByTwoId(String rolePermissionId,String roleId) {
        return rolePermissionService.deleteByTwoId(rolePermissionId,roleId);
    }

    @ApiOperation("新增角色权限关联")
    @PostMapping("/addRolePermission")
    public RestObject<String> addRolePermission(String rolePermissionId, String roleId) {
        return rolePermissionService.addRolePermission(rolePermissionId,roleId);
    }
}

package com.zhou.shop.apply.controller.admin;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zhou.shop.api.entity.user.Role;
import com.zhou.shop.apiServer.service.admin.IRoleService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/6 17:58
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    private final IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @SaCheckRole("superAdmin")
    @ApiOperation("查询全部角色")
    @GetMapping("/retrieveAllRole")
    public RestObject<List<Role>> retrieveAllRole() {
        return roleService.retrieveAllRole();
    }
}

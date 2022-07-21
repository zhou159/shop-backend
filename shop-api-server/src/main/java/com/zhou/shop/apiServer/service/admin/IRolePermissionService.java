package com.zhou.shop.apiServer.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.entity.user.RolePermission;
import com.zhou.shop.common.RestObject;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/16 11:21
 */
public interface IRolePermissionService extends IService<RolePermission> {

    /**
     * 根据id删除
     * @param rolePermissionId 角色权限表id
     * @return 信息
     */
    RestObject<String> deleteRolePermissionById(String rolePermissionId);

    /**
     * 根据角色和权限id删除
     * @param permissionId 权限id
     * @param roleId 角色id
     * @return 信息
     */
    RestObject<String> deleteByTwoId(String permissionId, String roleId);

    /**
     * 新增角色权限关联
     * @param permissionId 权限id
     * @param roleId 角色id
     * @return 信息
     */
    RestObject<String> addRolePermission(String permissionId, String roleId);
}

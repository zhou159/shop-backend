package com.zhou.shop.apiServer.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.dto.PermissionDTO;
import com.zhou.shop.api.entity.user.Permission;
import com.zhou.shop.api.vo.admin.PermissionAddVO;
import com.zhou.shop.common.RestObject;

import java.util.List;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/16 11:20
 */
public interface IPermissionService extends IService<Permission> {
    /**
     * 查询全部权限（管理员）
     *
     * @return 权限集合
     */
    RestObject<List<PermissionDTO>> retrieveAllPermission();

    /**
     * 修改权限
     *
     * @param permission 权限
     * @return 修改成功与否
     */
    RestObject<String> updatePermission(Permission permission);

    /**
     * 锁定权限
     *
     * @param permissionId 权限id
     * @return 锁定成功与否
     */
    RestObject<String> lockPermission(String permissionId);

    /**
     * 解锁权限
     *
     * @param permissionId 权限id
     * @return 解锁成功与否
     */
    RestObject<String> unLockPermission(String permissionId);

    /**
     * 新增权限
     *
     * @param permissionAddVO 前端新增权限对象
     * @return 信息
     */
    RestObject<String> createPermission(PermissionAddVO permissionAddVO);

    /**
     * 根据id删除权限
     * @param permissionId 权限id
     * @return 信息
     */
    RestObject<String> deletePermission(String permissionId);

    /**
     * 按条件查询权限
     * @param permission 权限实体
     * @return 权限信息集合
     */
    RestObject<List<PermissionDTO>> searchPermission(Permission permission);
}

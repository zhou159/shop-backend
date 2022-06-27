package com.zhou.shop.apply.config;

import cn.dev33.satoken.stp.StpInterface;
import com.zhou.shop.api.entity.user.Permission;
import com.zhou.shop.api.entity.user.Role;
import com.zhou.shop.api.entity.user.RolePermission;
import com.zhou.shop.api.entity.user.UserRole;
import com.zhou.shop.apiServer.service.user.IPermissionService;
import com.zhou.shop.apiServer.service.user.IRolePermissionService;
import com.zhou.shop.apiServer.service.user.IRoleService;
import com.zhou.shop.apiServer.service.user.IUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouxiong
 * @description: sa-token权限，角色自定义实现类
 * @version: v1.0 2022/6/16 11:14 zhouxiong： 创建此类
 * @since 2022/6/16 11:14
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    Logger logger = LoggerFactory.getLogger(StpInterfaceImpl.class);

    @Autowired IRoleService roleService;

    @Autowired IPermissionService permissionService;

    @Autowired IUserRoleService userRoleService;

    @Autowired IRolePermissionService rolePermissionService;
    /**
     * 根据当前用户id获取权限名集合
     *
     * @param loginId 账号id
     * @param loginType 账号类型
     * @return 权限名集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {

        final ArrayList<String> permissionNameList = new ArrayList<>();
        for (UserRole userRole :
                userRoleService.lambdaQuery().eq(UserRole::getUserId, loginId).list()) {
            for (RolePermission rolePermission :
                    rolePermissionService
                            .lambdaQuery()
                            .eq(RolePermission::getRoleId, userRole.getRoleId())
                            .list()) {
                permissionNameList.add(
                        permissionService
                                .lambdaQuery()
                                .eq(Permission::getPermissionId, rolePermission.getPermissionId())
                                .one()
                                .getName());
            }
        }
        logger.info("用户：{}。权限列表：{}",loginId,permissionNameList);
        return permissionNameList;
    }

    /**
     * 根据当前用户id获取角色名集合
     *
     * @param loginId 账号id
     * @param loginType 账号类型
     * @return 角色名集合
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        final ArrayList<String> roleNameList = new ArrayList<>();
        for (UserRole userRole :
                userRoleService.lambdaQuery().eq(UserRole::getUserId, loginId).list()) {
            roleNameList.add(
                    roleService
                            .lambdaQuery()
                            .eq(Role::getRoleId, userRole.getRoleId())
                            .one()
                            .getName());
        }
        logger.info("用户：{}。角色列表：{}",loginId,roleNameList);
        return roleNameList;
    }
}

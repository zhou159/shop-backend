package com.zhou.shop.apiServer.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.zhou.shop.api.entity.user.Permission;
import com.zhou.shop.api.entity.user.RolePermission;
import com.zhou.shop.api.entity.user.UserRole;
import com.zhou.shop.apiServer.service.CommonService;
import com.zhou.shop.apiServer.service.admin.IPermissionService;
import com.zhou.shop.apiServer.service.admin.IRolePermissionService;
import com.zhou.shop.apiServer.service.admin.IUserRoleService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0-2022/6/30 16:43-zhouxiong： 创建此类
 * @since 2022/6/30 16:43
 */
@Service
public class CommonServiceImpl implements CommonService {
    private final Logger log = LoggerFactory.getLogger(CommonServiceImpl.class);
    private final IPermissionService permissionService;
    private final IUserRoleService userRoleService;
    private final IRolePermissionService rolePermissionService;

    public CommonServiceImpl(
            IPermissionService permissionService,
            IUserRoleService userRoleService,
            IRolePermissionService rolePermissionService) {
        this.permissionService = permissionService;
        this.userRoleService = userRoleService;
        this.rolePermissionService = rolePermissionService;
    }

    @Override
    public RestObject<List<JSONObject>> queryReferences(String userId) {
        long startTime = System.currentTimeMillis();

        final List<JSONObject> referenceList = new ArrayList<>();
        final Map<String, String> referenceMap = new HashMap<>(16);

        // 根据id查询出用户角色列表
        final List<UserRole> userRoleList =
                userRoleService.lambdaQuery().eq(UserRole::getUserId, userId).list();
        // 遍历用户角色列表
        for (UserRole userRole : userRoleList) {

            // 根据角色id查询出角色权限列表
            final List<RolePermission> rolePermissionList =
                    rolePermissionService
                            .lambdaQuery()
                            .eq(RolePermission::getRoleId, userRole.getRoleId())
                            .list();

            // 遍历角色权限列表
            for (RolePermission rolePermission : rolePermissionList) {

                // 根据权限id查询权限信息
                final Permission permission =
                        permissionService
                                .lambdaQuery()
                                .eq(Permission::getPermissionId, rolePermission.getPermissionId())
                                .one();

                final String reference = permission.getReference();
                final String name = permission.getName();

                // 新增未锁定条件
                if (permission.getLocked() == 0) {
                    // 采用HashMap去重
                    referenceMap.put(reference, name);
                }
            }
        }
        for (String s : referenceMap.keySet()) {
            final JSONObject entries = new JSONObject();
            entries.put("reference", s);
            entries.put("name", referenceMap.get(s));
            referenceList.add(entries);
        }

        long endTime = System.currentTimeMillis();
        log.info("路径列表:{},共耗时:{}ms", referenceList, endTime - startTime);
        return RestResponse.makeOkRsp(referenceList);
    }
}

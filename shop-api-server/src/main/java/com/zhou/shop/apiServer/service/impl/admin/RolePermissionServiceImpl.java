package com.zhou.shop.apiServer.service.impl.admin;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.user.RolePermission;
import com.zhou.shop.apiServer.mapper.admin.RolePermissionMapper;
import com.zhou.shop.apiServer.service.admin.IRolePermissionService;
import org.springframework.stereotype.Service;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/16 11:23
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission>
        implements IRolePermissionService {}

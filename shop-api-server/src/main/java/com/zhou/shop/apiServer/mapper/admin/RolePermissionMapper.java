package com.zhou.shop.apiServer.mapper.admin;

import com.zhou.shop.api.entity.user.RolePermission;
import com.zhou.shop.apiServer.common.mybatisPlusExtend.ExpandBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/16 11:24
 */
@Mapper
public interface RolePermissionMapper extends ExpandBaseMapper<RolePermission> {}

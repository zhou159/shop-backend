package com.zhou.shop.apiServer.mapper.admin;

import com.zhou.shop.api.dto.PermissionDTO;
import com.zhou.shop.api.entity.user.Permission;
import com.zhou.shop.apiServer.common.mybatisPlusExtend.ExpandBaseMapper;
import com.zhou.shop.apiServer.provider.PermissionProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/16 11:24
 */
@Mapper
public interface PermissionMapper extends ExpandBaseMapper<Permission> {
    /**
     * 按条件查询权限信息
     * @param permission 权限实体
     * @return 权限信息集合
     */
    @SelectProvider(type = PermissionProvider.class, method = "queryPermission")
    List<PermissionDTO> queryPermission(Permission permission);
}

package com.zhou.shop.apiServer.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.api.entity.user.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/16 11:24
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {}

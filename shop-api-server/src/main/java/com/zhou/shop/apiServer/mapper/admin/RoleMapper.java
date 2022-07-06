package com.zhou.shop.apiServer.mapper.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.api.entity.user.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/16 11:24
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {}

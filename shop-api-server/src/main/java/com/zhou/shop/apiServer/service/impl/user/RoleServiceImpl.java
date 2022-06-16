package com.zhou.shop.apiServer.service.impl.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.user.Role;
import com.zhou.shop.apiServer.mapper.user.RoleMapper;
import com.zhou.shop.apiServer.service.user.IRoleService;
import org.springframework.stereotype.Service;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/16 11:23
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {}

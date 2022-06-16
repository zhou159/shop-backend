package com.zhou.shop.apiServer.service.impl.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.user.UserRole;
import com.zhou.shop.apiServer.mapper.user.UserRoleMapper;
import com.zhou.shop.apiServer.service.user.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/16 11:23
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {}

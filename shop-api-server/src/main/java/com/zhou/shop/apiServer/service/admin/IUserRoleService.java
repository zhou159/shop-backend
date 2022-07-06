package com.zhou.shop.apiServer.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.entity.user.UserRole;
import com.zhou.shop.common.RestObject;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/16 11:21
 */
public interface IUserRoleService extends IService<UserRole> {
    /**
     * 新增用户角色关系
     * @param userRole 用户角色关系对象
     * @return 信息
     */
    RestObject<String> createUserRole(UserRole userRole);
}

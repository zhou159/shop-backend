package com.zhou.shop.apiServer.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.entity.user.Role;
import com.zhou.shop.common.RestObject;

import java.util.List;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/16 11:20
 */
public interface IRoleService extends IService<Role> {
    /**
     * 查询全部角色
     * @return 角色集合
     */
    RestObject<List<Role>> retrieveAllRole();

    /**
     * 新增角色
     * @param role 角色对象
     * @return 信息
     */
    RestObject<String> createRole(Role role);

    /**
     * 修改角色
     * @param role 角色对象
     * @return 信息
     */
    RestObject<String> updateRole(Role role);

    /**
     * 删除角色
     * @param roleId 角色id
     * @return 信息
     */
    RestObject<String> deleteRole(String roleId);
}

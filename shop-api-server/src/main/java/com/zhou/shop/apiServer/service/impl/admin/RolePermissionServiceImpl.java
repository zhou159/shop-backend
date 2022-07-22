package com.zhou.shop.apiServer.service.impl.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.user.RolePermission;
import com.zhou.shop.apiServer.mapper.admin.RolePermissionMapper;
import com.zhou.shop.apiServer.service.admin.IRolePermissionService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.common.exception.ShopException;
import org.springframework.stereotype.Service;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/16 11:23
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission>
        implements IRolePermissionService {
    private final RolePermissionMapper rolePermissionMapper;

    public RolePermissionServiceImpl(RolePermissionMapper rolePermissionMapper) {
        this.rolePermissionMapper = rolePermissionMapper;
    }

    @Override
    public RestObject<String> deleteRolePermissionById(String rolePermissionId) {
        int i = rolePermissionMapper.deleteById(rolePermissionId);
        return i > 0 ? RestResponse.makeOkRsp("删除成功！") : RestResponse.makeErrRsp("删除失败！");
    }

    @Override
    public RestObject<String> deleteByTwoId(String permissionId, String roleId) {
        int delete =
                rolePermissionMapper.delete(
                        new LambdaQueryWrapper<RolePermission>()
                                .eq(RolePermission::getPermissionId, permissionId)
                                .eq(RolePermission::getRoleId, roleId));
        return delete > 0 ? RestResponse.makeOkRsp("删除成功！") : RestResponse.makeErrRsp("删除失败！");
    }

    @Override
    public RestObject<String> addRolePermission(String permissionId, String roleId) {
        Long aLong =
                rolePermissionMapper.selectCount(
                        new LambdaQueryWrapper<RolePermission>()
                                .eq(RolePermission::getPermissionId, permissionId)
                                .eq(RolePermission::getRoleId, roleId));
        if(aLong > 0){
            throw new ShopException("该权限下该角色已存在，请勿重复操作！");
        }
        int insert =
                rolePermissionMapper.insert(
                        new RolePermission().setPermissionId(permissionId).setRoleId(roleId));
        return insert > 0 ? RestResponse.makeOkRsp("添加成功！") : RestResponse.makeErrRsp("添加失败！");
    }
}

package com.zhou.shop.apiServer.service.impl.admin;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.user.Role;
import com.zhou.shop.apiServer.mapper.admin.RoleMapper;
import com.zhou.shop.apiServer.service.admin.IRoleService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/16 11:23
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public RestObject<List<Role>> retrieveAllRole() {
        return RestResponse.makeOkRsp(this.getBaseMapper().selectList(null));
    }

    @Override
    public RestObject<String> createRole(Role role) {
        int insert = this.getBaseMapper().insert(role);
        return insert > 0 ? RestResponse.makeOkRsp("新增成功！") : RestResponse.makeErrRsp("新增失败！");
    }

    @Override
    public RestObject<String> updateRole(Role role) {
        int i = this.getBaseMapper().updateById(role);
        return i > 0 ? RestResponse.makeOkRsp("新增成功！") : RestResponse.makeErrRsp("新增失败！");
    }

    @Override
    public RestObject<String> deleteRole(String roleId) {
        int i = this.getBaseMapper().deleteById(roleId);
        return i > 0 ? RestResponse.makeOkRsp("新增成功！") : RestResponse.makeErrRsp("新增失败！");
    }
}

package com.zhou.shop.apiServer.service.impl.admin;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.user.UserRole;
import com.zhou.shop.apiServer.mapper.admin.UserRoleMapper;
import com.zhou.shop.apiServer.service.admin.IUserRoleService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import org.springframework.stereotype.Service;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/16 11:23
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
        implements IUserRoleService {
    @Override
    public RestObject<String> createUserRole(UserRole userRole) {
        int insert = this.getBaseMapper().insert(userRole);
        return insert > 0 ? RestResponse.makeOkRsp("新增成功！") : RestResponse.makeErrRsp("新增失败！");
    }
}

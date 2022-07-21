package com.zhou.shop.apiServer.service.impl.admin;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.dto.PermissionDTO;
import com.zhou.shop.api.entity.user.Permission;
import com.zhou.shop.api.entity.user.Role;
import com.zhou.shop.api.entity.user.RolePermission;
import com.zhou.shop.api.entity.user.User;
import com.zhou.shop.api.vo.admin.PermissionAddVO;
import com.zhou.shop.apiServer.mapper.admin.PermissionMapper;
import com.zhou.shop.apiServer.mapper.admin.RoleMapper;
import com.zhou.shop.apiServer.mapper.admin.RolePermissionMapper;
import com.zhou.shop.apiServer.mapper.user.UserMapper;
import com.zhou.shop.apiServer.service.admin.IPermissionService;
import com.zhou.shop.common.BaseConstant;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.common.exception.ShopException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/16 11:23
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
        implements IPermissionService {

    private final PermissionMapper permissionMapper;
    private final RolePermissionMapper rolePermissionMapper;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    private static final String PERMISSION_UNLOCKED = BaseConstant.ZERO_STR;
    private static final String PERMISSION_LOCKED = BaseConstant.ONE_STR;

    public PermissionServiceImpl(
            PermissionMapper permissionMapper,
            RolePermissionMapper rolePermissionMapper,
            UserMapper userMapper,
            RoleMapper roleMapper) {
        this.permissionMapper = permissionMapper;
        this.rolePermissionMapper = rolePermissionMapper;
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public RestObject<List<PermissionDTO>> retrieveAllPermission() {
        List<PermissionDTO> permissionDTOList = new ArrayList<>();
        List<Permission> permissions = permissionMapper.selectList(null);
        for (Permission permission : permissions) {

            PermissionDTO permissionDTO = new PermissionDTO();
            BeanUtils.copyProperties(permission, permissionDTO);
            if (StrUtil.isNotEmpty(permission.getLockedBy())) {
                User user =
                        userMapper.selectOne(
                                new LambdaQueryWrapper<User>()
                                        .eq(User::getUserId, permission.getLockedBy()));
                permissionDTO.setLockedByName(user.getUsername());
            }
            permissionDTOList.add(permissionDTO);
        }
        // 查询全部未锁定全权限
        return RestResponse.makeOkRsp(permissionDTOList);
    }

    @Override
    public RestObject<String> updatePermission(Permission permission) {
        int i = permissionMapper.updateById(permission);
        return i > 0 ? RestResponse.makeOkRsp("修改成功！") : RestResponse.makeErrRsp("修改失败！");
    }

    @Override
    public RestObject<String> lockPermission(String permissionId) {
        int update =
                permissionMapper.update(
                        null,
                        new LambdaUpdateWrapper<Permission>()
                                .eq(Permission::getPermissionId, permissionId)
                                // 将权限管理排除
                                .ne(Permission::getPermissionId, "10")
                                .set(Permission::getLocked, PERMISSION_LOCKED)
                                .set(Permission::getLockedBy, StpUtil.getLoginId())
                                .set(Permission::getLockedTime, LocalDateTime.now()));
        return update > 0 ? RestResponse.makeOkRsp("锁定成功！") : RestResponse.makeErrRsp("锁定失败！");
    }

    @Override
    public RestObject<String> unLockPermission(String permissionId) {
        int update =
                permissionMapper.update(
                        null,
                        new LambdaUpdateWrapper<Permission>()
                                .eq(Permission::getPermissionId, permissionId)
                                .eq(Permission::getLocked, PERMISSION_LOCKED)
                                .set(Permission::getLocked, PERMISSION_UNLOCKED)
                                .set(Permission::getLockedBy, null)
                                .set(Permission::getLockedTime, null));
        return update > 0 ? RestResponse.makeOkRsp("解锁成功！") : RestResponse.makeErrRsp("解锁失败！");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public RestObject<String> createPermission(PermissionAddVO permissionAddVO) {
        List<RolePermission> rolePermissionList = new ArrayList<>();
        // 雪花算法生成permissionId
        final String permissionId = String.valueOf(new Snowflake().nextId());

        Permission permission = new Permission(permissionId);
        BeanUtils.copyProperties(permissionAddVO, permission);

        int insert = permissionMapper.insert(permission);

        // 遍历前端传入的角色id集合
        List<String> roleIds = permissionAddVO.getRoleIds();

        roleIds.forEach(
                id ->
                        rolePermissionList.add(
                                new RolePermission().setRoleId(id).setPermissionId(permissionId)));
        Integer integer = rolePermissionMapper.insertBatchSomeColumn(rolePermissionList);

        // 两句插入语句有一句未执行成功，抛异常，回滚。
        boolean i = insert < 1 || integer < 1;
        if (i) {
            throw new ShopException("新增失败！");
        }
        return RestResponse.makeOkRsp("新增成功！");
    }

    @Override
    public RestObject<String> deletePermission(String permissionId) {
        // 暂时未作其他判断，直接逻辑删除。
        int delete =
                permissionMapper.delete(
                        new LambdaQueryWrapper<Permission>()
                                .eq(Permission::getPermissionId, permissionId));
        return delete > 0 ? RestResponse.makeOkRsp("删除成功！") : RestResponse.makeErrRsp("删除失败！");
    }

    @Override
    public RestObject<List<PermissionDTO>> searchPermission(Permission permission) {
        return RestResponse.makeOkRsp(permissionMapper.queryPermission(permission));
    }

    @Override
    public RestObject<List<Role>> queryRolesByPermissionId(String permissionId) {
        ArrayList<Role> roleList = new ArrayList<>();
        // 根据权限id查询出角色权限列表

        rolePermissionMapper
                .selectList(
                        new LambdaQueryWrapper<RolePermission>()
                                .eq(RolePermission::getPermissionId, permissionId))
                .forEach(
                        rolePermission -> {
                            Role role =
                                    roleMapper.selectOne(
                                            new LambdaQueryWrapper<Role>()
                                                    .eq(
                                                            Role::getRoleId,
                                                            rolePermission.getRoleId()));
                            roleList.add(role);
                        });
        return RestResponse.makeOkRsp(roleList);
    }
}

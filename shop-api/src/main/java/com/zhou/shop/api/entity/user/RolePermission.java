package com.zhou.shop.api.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 周雄
 * @date 2022/4/2 17:27
 * @description
 */
@ApiModel("角色权限")
@TableName("role_permission")
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色权限表id")
    @TableId(value = "role_permission_id", type = IdType.ASSIGN_ID)
    private String rolePermissionId;

    @ApiModelProperty("角色id")
    @TableField("role_id")
    private String roleId;

    @ApiModelProperty("权限id")
    @TableField("permission_id")
    private String permissionId;

    public RolePermission() {}

    public RolePermission(String rolePermissionId, String roleId, String permissionId) {
        this.rolePermissionId = rolePermissionId;
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public String getRolePermissionId() {
        return rolePermissionId;
    }

    public RolePermission setRolePermissionId(String rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
        return this;
    }

    public String getRoleId() {
        return roleId;
    }

    public RolePermission setRoleId(String roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public RolePermission setPermissionId(String permissionId) {
        this.permissionId = permissionId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePermission that = (RolePermission) o;
        return rolePermissionId.equals(that.rolePermissionId)
                && roleId.equals(that.roleId)
                && permissionId.equals(that.permissionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolePermissionId, roleId, permissionId);
    }

    @Override
    public String toString() {
        return "RolePermission{"
                + "rolePermissionId='"
                + rolePermissionId
                + '\''
                + ", roleId='"
                + roleId
                + '\''
                + ", permissionId='"
                + permissionId
                + '\''
                + '}';
    }
}

package com.zhou.shop.api.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 周雄
 * @date 2022/4/2 17:17
 * @description 权限表实体
 */
@TableName("permission")
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "权限表id")
    @TableId(value = "permission_id", type = IdType.ASSIGN_ID)
    private String permissionId;

    @ApiModelProperty(value = "前端索引")
    @TableField("reference")
    private String reference;

    @ApiModelProperty(value = "权限名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "权限介绍")
    @TableField("description")
    private String description;

    public Permission() {}

    public Permission(String permissionId, String reference, String name, String description) {
        this.permissionId = permissionId;
        this.reference = reference;
        this.name = name;
        this.description = description;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public Permission setPermissionId(String permissionId) {
        this.permissionId = permissionId;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public Permission setReference(String reference) {
        this.reference = reference;
        return this;
    }

    public String getName() {
        return name;
    }

    public Permission setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Permission setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return permissionId.equals(that.permissionId)
                && reference.equals(that.reference)
                && name.equals(that.name)
                && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionId, reference, name, description);
    }

    @Override
    public String toString() {
        return "Permission{"
                + "permissionId='"
                + permissionId
                + '\''
                + ", reference='"
                + reference
                + '\''
                + ", name='"
                + name
                + '\''
                + ", description='"
                + description
                + '\''
                + '}';
    }
}

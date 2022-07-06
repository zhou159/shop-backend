package com.zhou.shop.api.entity.user;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author 周雄
 * @date 2022/4/2 17:17
 * @description 权限表实体
 */
@ApiModel("权限")
@TableName("permission")
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("权限表id")
    @TableId(value = "permission_id", type = IdType.NONE)
    private String permissionId;

    @ApiModelProperty("前端索引")
    @TableField("reference")
    private String reference;

    @ApiModelProperty("权限名")
    @TableField("name")
    private String name;

    @ApiModelProperty("权限介绍")
    @TableField("description")
    private String description;

    @ApiModelProperty("逻辑删除")
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    @ApiModelProperty("权限是否锁定（1：锁定）")
    @TableField("locked")
    private Integer locked;

    @ApiModelProperty("权限锁定者")
    @TableField("lockedBy")
    private String lockedBy;

    @ApiModelProperty("权限锁定时间")
    @TableField("lockedTime")
    private String lockedTime;

    public Permission() {}

    public Permission(String permissionId) {
        this.permissionId = permissionId;
    }

    public Permission(
            String permissionId,
            String reference,
            String name,
            String description,
            Integer deleted,
            Integer locked,
            String lockedBy,
            String lockedTime) {
        this.permissionId = permissionId;
        this.reference = reference;
        this.name = name;
        this.description = description;
        this.deleted = deleted;
        this.locked = locked;
        this.lockedBy = lockedBy;
        this.lockedTime = lockedTime;
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public String getLockedBy() {
        return lockedBy;
    }

    public void setLockedBy(String lockedBy) {
        this.lockedBy = lockedBy;
    }

    public String getLockedTime() {
        return lockedTime;
    }

    public void setLockedTime(String lockedTime) {
        this.lockedTime = lockedTime;
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
                + ", deleted="
                + deleted
                + ", locked="
                + locked
                + ", lockedBy="
                + lockedBy
                + ", lockedTime="
                + lockedTime
                + '}';
    }
}

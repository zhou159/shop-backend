package com.zhou.shop.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/12 15:57
 */
@ApiModel("后端返回权限对象")
public class PermissionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("权限表id")
    private String permissionId;

    @ApiModelProperty("前端索引")
    private String reference;

    @ApiModelProperty("权限名")
    private String name;

    @ApiModelProperty("权限介绍")
    private String description;

    @ApiModelProperty("权限是否锁定（1：锁定）")
    private Integer locked;

    @ApiModelProperty("权限锁定者")
    private String lockedByName;

    @ApiModelProperty("权限锁定时间")
    private String lockedTime;

    public PermissionDTO() {}

    public PermissionDTO(
            String permissionId,
            String reference,
            String name,
            String description,
            Integer locked,
            String lockedByName,
            String lockedTime) {
        this.permissionId = permissionId;
        this.reference = reference;
        this.name = name;
        this.description = description;
        this.locked = locked;
        this.lockedByName = lockedByName;
        this.lockedTime = lockedTime;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public String getLockedByName() {
        return lockedByName;
    }

    public void setLockedByName(String lockedByName) {
        this.lockedByName = lockedByName;
    }

    public String getLockedTime() {
        return lockedTime;
    }

    public void setLockedTime(String lockedTime) {
        this.lockedTime = lockedTime;
    }

    @Override
    public String toString() {
        return "PermissionDTO{"
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
                + ", locked="
                + locked
                + ", lockedByName='"
                + lockedByName
                + '\''
                + ", lockedTime='"
                + lockedTime
                + '\''
                + '}';
    }
}

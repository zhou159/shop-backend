package com.zhou.shop.api.vo.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/6 10:35
 */
@ApiModel("前端新增权限对象")
public class PermissionAddVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("前端索引")
    private String reference;

    @ApiModelProperty("权限名")
    private String name;

    @ApiModelProperty("权限介绍")
    private String description;

    @ApiModelProperty("角色id")
    private List<String> roleIds;

    public PermissionAddVO() {}

    public PermissionAddVO(String reference, String name, String description, List<String> roleIds) {
        this.reference = reference;
        this.name = name;
        this.description = description;
        this.roleIds = roleIds;
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

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public String toString() {
        return "PermissionAddVO{"
                + "reference='"
                + reference
                + '\''
                + ", name='"
                + name
                + '\''
                + ", description='"
                + description
                + '\''
                + ", roleIds='"
                + roleIds
                + '\''
                + '}';
    }
}

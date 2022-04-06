package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 周雄
 * @date 2022/4/2 17:24
 * @description
 */
@TableName("role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色表id")
    @TableId(value = "role_id", type = IdType.ASSIGN_ID)
    private String roleId;

    @ApiModelProperty(value = "角色标签")
    @TableField("label")
    private String label;

    @ApiModelProperty(value = "角色名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "角色介绍")
    @TableField("description")
    private String description;

    public Role() {}

    public Role(String roleId, String label, String name, String description) {
        this.roleId = roleId;
        this.label = label;
        this.name = name;
        this.description = description;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleId.equals(role.roleId)
                && label.equals(role.label)
                && name.equals(role.name)
                && description.equals(role.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, label, name, description);
    }

    @Override
    public String toString() {
        return "Role{"
                + "roleId='"
                + roleId
                + '\''
                + ", label='"
                + label
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

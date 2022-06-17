package com.zhou.shop.common.enums;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0-2022/6/17 17:16-zhouxiong： 创建此类
 * @since 2022/6/17 17:16
 */
public enum RoleEnum {
    /** 管理员用户 */
    ADMIM("1", "admin", "管理员", "管理员"),
    /** 超级管理员用户 */
    SUPER_ADMIN("3", "superAdmin", "超级管理员", "超级管理员"),
    /** 普通用户 */
    USER("2", "user", "普通用户", "普通用户");

    private final String roleId;
    private final String name;
    private final String description;
    private final String label;

    RoleEnum(String roleId, String name, String description, String label) {
        this.roleId = roleId;
        this.name = name;
        this.description = description;
        this.label = label;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }
}

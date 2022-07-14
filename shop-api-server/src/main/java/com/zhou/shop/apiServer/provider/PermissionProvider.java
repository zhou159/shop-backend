package com.zhou.shop.apiServer.provider;

import cn.hutool.core.util.StrUtil;
import com.zhou.shop.api.entity.user.Permission;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/14 9:02
 */
public class PermissionProvider {

    public String queryPermission(Permission permission) {
        StringBuilder sql = new StringBuilder();
        sql.append(
                "SELECT\n"
                        + "\tp.permission_id,\n"
                        + "\tp.reference,\n"
                        + "\tp.`name`,\n"
                        + "\tp.description,\n"
                        + "\tp.lockedBy,\n"
                        + "\tp.locked,\n"
                        + "\tp.lockedTime,\n"
                        + "\tu.username AS lockedByName \n"
                        + "FROM\n"
                        + "\tpermission AS p\n"
                        + "LEFT JOIN\n"
                        + "\t`user` AS u \n"
                        + "ON p.lockedBy = u.user_id \n"
                        + "where p.deleted = 0\n");
        if (StrUtil.isNotBlank(permission.getReference())) {
            sql.append("and p.reference like '%").append(permission.getReference()).append("%'");
        }
        if (StrUtil.isNotBlank(permission.getName())) {
            sql.append("and p.name like '%").append(permission.getName()).append("%'");
        }
        if (StrUtil.isNotBlank(permission.getDescription())) {
            sql.append("and p.description like '%").append(permission.getDescription()).append("%'");
        }
        if (permission.getLocked() != null) {
            sql.append("and p.locked = ").append(permission.getLocked());
        }
        return sql.toString();
    }
}

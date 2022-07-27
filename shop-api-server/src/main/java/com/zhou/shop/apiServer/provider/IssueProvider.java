package com.zhou.shop.apiServer.provider;

import cn.hutool.core.util.StrUtil;
import com.zhou.shop.api.entity.Issue;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/27 16:17
 */
public class IssueProvider {
    public String queryIssue(Issue issue) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT\n" +
                "\t`is`.issue_id,\n" +
                "\t`is`.issue_create_time,\n" +
                "\t`is`.issue_description,\n" +
                "\t( SELECT pc.pub_code_name FROM pub_code AS pc WHERE `is`.issue_module = pc.pub_code_id ) issueModuleName,\n" +
                "\t( SELECT pc.pub_code_name FROM pub_code AS pc WHERE `is`.issue_type = pc.pub_code_id ) issueTypeName,\n" +
                "\t`is`.issue_module,\n" +
                "\t`is`.issue_type,\n" +
                "\t`is`.issue_status,\n" +
                "\t`is`.issue_solve_time,\n" +
                "\t`is`.issue_close_time,\n" +
                "\t`is`.issue_create_by,\n" +
                "\t`is`.issue_deleted \n" +
                "FROM\n" +
                "\tissue AS `is` \n" +
                "WHERE\n" +
                "\t`is`.issue_deleted = 0 \n" +
                "\tAND `is`.issue_status = '0'\n");
        if(StrUtil.isNotBlank(issue.getIssueType())){
            sql.append("and `is`.issue_type = '").append(issue.getIssueType()).append("'");
        }
        if(StrUtil.isNotBlank(issue.getIssueModule())){
            sql.append("and `is`.issue_module = '").append(issue.getIssueModule()).append("'");
        }
        if(StrUtil.isNotBlank(issue.getIssueDescription())){
            sql.append("and `is`.issue_description like '%").append(issue.getIssueDescription()).append("%'");
        }

        return sql.toString();
    }
}

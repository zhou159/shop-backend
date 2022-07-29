package com.zhou.shop.apiServer.provider;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/29 10:49
 */
public class SitcomProvider {
    public String queryAllSitcom(String userId) {
        return "SELECT\n" +
                "\ts.sitcom_id,\n" +
                "\ts.sitcom_name,\n" +
                "\ts.sitcom_watch_start_time,\n" +
                "\ts.sitcom_watch_end_time,\n" +
                "\ts.sitcom_update_status,\n" +
                "\ts.sitcom_picture,\n" +
                "\ts.sitcom_url,\n" +
                "\ts.sitcom_remark,\n" +
                "\ts.sitcom_watch_status,\n" +
                "\ts.sitcom_country,\n" +
                "\ts.sitcom_director,\n" +
                "\ts.sitcom_type,\n" +
                "\t( SELECT p.pub_code_name FROM pub_code AS p WHERE s.sitcom_type = p.pub_code_id ) AS sitcomTypeName,\n" +
                "\t( SELECT p.pub_code_name FROM pub_code AS p WHERE s.sitcom_country = p.pub_code_id ) AS sitcomCountryName,\n" +
                "\ts.sitcom_style,\n" +
                "\ts.sitcom_intro,\n" +
                "\ts.sitcom_deleted,\n" +
                "\ts.user_id \n" +
                "FROM\n" +
                "\tsitcom AS s \n" +
                "WHERE\n" +
                "\ts.user_id = '" +
                userId + "'";
    }
}

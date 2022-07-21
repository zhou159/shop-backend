package com.zhou.shop.apiServer.provider;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/21 10:47
 */
public class PubCodeProvider {
    public String queryPubCode(String pubCodeType) {
        StringBuilder sql = new StringBuilder();
        sql.append(
                "SELECT\n"
                        + "\tpc.pub_code_id,\n"
                        + "\tpc.pub_code_name,\n"
                        + "\tpc.pub_code_type_id,\n"
                        + "\tpc.pub_code_description,\n"
                        + "\tpc.pub_code_create_time,\n"
                        + "\tpc.pub_code_update_time \n"
                        + "FROM\n"
                        + "\tpub_code_type AS pct\n"
                        + "\tLEFT JOIN pub_code AS pc ON pct.id = pc.pub_code_type_id \n"
                        + "WHERE\n"
                        + "\tpct.deleted = 0 \n"
                        + "\tAND pc.deleted = 0 \n"
                        + "\tAND pct.pub_code_type = '"
                        + pubCodeType
                        + "'");

        return sql.toString();
    }
}

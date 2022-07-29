package com.zhou.shop.apiServer.provider;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/29 15:55
 */
public class BlogProvider {
    private final static String SQL = "SELECT\n" +
            "\tb.blog_id, \n" +
            "\tb.blog_create_time, \n" +
            "\tb.blog_update_time, \n" +
            "\tb.blog_title, \n" +
            "\tb.blog_text, \n" +
            "\tb.blog_text_intro, \n" +
            "\tb.blog_category, \n" +
            "\t( SELECT bc.blog_category_name FROM blog_category AS bc WHERE b.blog_category = bc.blog_category_id ) AS blogCategoryName, \n" +
            "\tb.blog_flag, \n" +
            "\t( SELECT p.pub_code_name FROM pub_code AS p WHERE b.blog_flag = p.pub_code_id ) AS blogFlagName, \n" +
            "\tb.blog_deleted, \n" +
            "\tb.blog_create_by,\n" +
            "\t( SELECT u.username FROM user AS u WHERE b.blog_create_by = u.user_id ) AS blogCreatedName\n" +
            "FROM\n" +
            "\tblog AS b";

    public String queryAllBlog() {
        return SQL;
    }

    public String queryAllByBlogCategoryId(String blogCategoryId){
        return SQL + "\twhere b.blog_category = '" + blogCategoryId + "'";
    }
}

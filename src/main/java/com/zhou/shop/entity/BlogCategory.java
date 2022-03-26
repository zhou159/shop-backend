package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author 周雄
 * @date 2022/3/26 17:09
 * @description
 */
@TableName("blog_category")
public class BlogCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("博客栏目id")
    @TableId(value = "blog_id", type = IdType.ASSIGN_ID)
    private String blogCategoryId;

    @ApiModelProperty("博客栏目名字")
    @TableField("blog_category_name")
    private String blogCategoryName;

    @ApiModelProperty("博客栏目创建人")
    @TableField("blog_category_created_by")
    private String blogCategoryCreatedBy;

    public BlogCategory() {}

    public BlogCategory(
            String blogCategoryId, String blogCategoryName, String blogCategoryCreatedBy) {
        this.blogCategoryId = blogCategoryId;
        this.blogCategoryName = blogCategoryName;
        this.blogCategoryCreatedBy = blogCategoryCreatedBy;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBlogCategoryId() {
        return blogCategoryId;
    }

    public void setBlogCategoryId(String blogCategoryId) {
        this.blogCategoryId = blogCategoryId;
    }

    public String getBlogCategoryName() {
        return blogCategoryName;
    }

    public void setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName;
    }

    public String getBlogCategoryCreatedBy() {
        return blogCategoryCreatedBy;
    }

    public void setBlogCategoryCreatedBy(String blogCategoryCreatedBy) {
        this.blogCategoryCreatedBy = blogCategoryCreatedBy;
    }

    @Override
    public String toString() {
        return "BlogCategory{"
                + "blogCategoryId='"
                + blogCategoryId
                + '\''
                + ", blogCategoryName='"
                + blogCategoryName
                + '\''
                + ", blogCategoryCreatedBy='"
                + blogCategoryCreatedBy
                + '\''
                + '}';
    }
}

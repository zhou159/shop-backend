package com.zhou.shop.api.entity;

import com.baomidou.mybatisplus.annotation.*;
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
    @TableId(value = "blog_category_id", type = IdType.ASSIGN_ID)
    private String blogCategoryId;

    @ApiModelProperty("博客栏目名字")
    @TableField("blog_category_name")
    private String blogCategoryName;

    @ApiModelProperty("博客栏目创建人")
    @TableField("blog_category_created_by")
    private String blogCategoryCreatedBy;

    @ApiModelProperty("博客栏目简介")
    @TableField("blog_category_description")
    private String blogCategoryDescription;

    @TableLogic
    @ApiModelProperty("博客栏目逻辑删除")
    @TableField("blog_category_deleted")
    private Integer blogCategoryDeleted;

    public BlogCategory() {}

    public BlogCategory(
            String blogCategoryId,
            String blogCategoryName,
            String blogCategoryCreatedBy,
            String blogCategoryDescription) {
        this.blogCategoryId = blogCategoryId;
        this.blogCategoryName = blogCategoryName;
        this.blogCategoryCreatedBy = blogCategoryCreatedBy;
        this.blogCategoryDescription = blogCategoryDescription;
    }

    public String getBlogCategoryId() {
        return blogCategoryId;
    }

    public BlogCategory setBlogCategoryId(String blogCategoryId) {
        this.blogCategoryId = blogCategoryId;
        return this;
    }

    public String getBlogCategoryName() {
        return blogCategoryName;
    }

    public BlogCategory setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName;
        return this;
    }

    public String getBlogCategoryCreatedBy() {
        return blogCategoryCreatedBy;
    }

    public BlogCategory setBlogCategoryCreatedBy(String blogCategoryCreatedBy) {
        this.blogCategoryCreatedBy = blogCategoryCreatedBy;
        return this;
    }

    public String getBlogCategoryDescription() {
        return blogCategoryDescription;
    }

    public BlogCategory setBlogCategoryDescription(String blogCategoryDescription) {
        this.blogCategoryDescription = blogCategoryDescription;
        return this;
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
                + ", blogCategoryDescription='"
                + blogCategoryDescription
                + '\''
                + '}';
    }
}

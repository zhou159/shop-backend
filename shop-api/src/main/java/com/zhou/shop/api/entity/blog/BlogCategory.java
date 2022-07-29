package com.zhou.shop.api.entity.blog;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 周雄
 * @date 2022/3/26 17:09
 * @description
 */
@ApiModel("博客栏目")
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

    @ApiModelProperty("博客栏目创建时间")
    @TableField("blog_category_create_time")
    private LocalDateTime blogCategoryCreateTime;

    @ApiModelProperty("博客栏目更新时间")
    @TableField("blog_category_update_time")
    private LocalDateTime blogCategoryUpdateTime;

    @TableLogic
    @ApiModelProperty("博客栏目逻辑删除")
    @TableField("blog_category_deleted")
    private Integer blogCategoryDeleted;

    public BlogCategory() {
    }

    public BlogCategory(String blogCategoryId, String blogCategoryName, String blogCategoryCreatedBy, String blogCategoryDescription, LocalDateTime blogCategoryCreateTime, LocalDateTime blogCategoryUpdateTime, Integer blogCategoryDeleted) {
        this.blogCategoryId = blogCategoryId;
        this.blogCategoryName = blogCategoryName;
        this.blogCategoryCreatedBy = blogCategoryCreatedBy;
        this.blogCategoryDescription = blogCategoryDescription;
        this.blogCategoryCreateTime = blogCategoryCreateTime;
        this.blogCategoryUpdateTime = blogCategoryUpdateTime;
        this.blogCategoryDeleted = blogCategoryDeleted;
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

    public LocalDateTime getBlogCategoryCreateTime() {
        return blogCategoryCreateTime;
    }

    public void setBlogCategoryCreateTime(LocalDateTime blogCategoryCreateTime) {
        this.blogCategoryCreateTime = blogCategoryCreateTime;
    }

    public LocalDateTime getBlogCategoryUpdateTime() {
        return blogCategoryUpdateTime;
    }

    public void setBlogCategoryUpdateTime(LocalDateTime blogCategoryUpdateTime) {
        this.blogCategoryUpdateTime = blogCategoryUpdateTime;
    }

    public Integer getBlogCategoryDeleted() {
        return blogCategoryDeleted;
    }

    public void setBlogCategoryDeleted(Integer blogCategoryDeleted) {
        this.blogCategoryDeleted = blogCategoryDeleted;
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
        return "BlogCategory{" + "blogCategoryId='" + blogCategoryId + '\'' + ", blogCategoryName='" + blogCategoryName + '\'' + ", blogCategoryCreatedBy='" + blogCategoryCreatedBy + '\'' + ", blogCategoryDescription='" + blogCategoryDescription + '\'' + ", blogCategoryCreateTime='" + blogCategoryCreateTime + '\'' + ", blogCategoryUpdateTime='" + blogCategoryUpdateTime + '\'' + ", blogCategoryDeleted=" + blogCategoryDeleted + '}';
    }
}

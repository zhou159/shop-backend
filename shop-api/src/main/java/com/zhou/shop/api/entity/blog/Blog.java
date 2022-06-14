package com.zhou.shop.api.entity.blog;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 周雄
 * @date 2022/3/26 17:00
 * @description
 */
@TableName("blog")
@ApiModel("博客")
public class Blog implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("博客id")
    @TableId(value = "blog_id", type = IdType.ASSIGN_ID)
    private String blogId;

    @ApiModelProperty("博客创建时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("blog_create_time")
    private LocalDateTime blogCreateTime;

    @ApiModelProperty("博客标题")
    @TableField("blog_title")
    private String blogTitle;

    @ApiModelProperty("博客创建人")
    @TableField("blog_create_by")
    private String blogCreatedBy;

    @ApiModelProperty("博客内容")
    @TableField("blog_text")
    private String blogText;

    @ApiModelProperty("博客所属栏目")
    @TableField("blog_category")
    private String blogCategory;

    @ApiModelProperty("博客标签")
    @TableField("blog_flag")
    private String blogFlag;

    @TableLogic
    @ApiModelProperty("博客逻辑删除")
    @TableField("blog_deleted")
    private Integer blogDeleted;

    public Blog() {}

    public Blog(
            String blogId,
            LocalDateTime blogCreateTime,
            String blogTitle,
            String blogCreatedBy,
            String blogText,
            String blogCategory,
            String blogFlag) {
        this.blogId = blogId;
        this.blogCreateTime = blogCreateTime;
        this.blogTitle = blogTitle;
        this.blogCreatedBy = blogCreatedBy;
        this.blogText = blogText;
        this.blogCategory = blogCategory;
        this.blogFlag = blogFlag;
    }

    public String getBlogId() {
        return blogId;
    }

    public Blog setBlogId(String blogId) {
        this.blogId = blogId;
        return this;
    }

    public LocalDateTime getBlogCreateTime() {
        return blogCreateTime;
    }

    public Blog setBlogCreateTime(LocalDateTime blogCreateTime) {
        this.blogCreateTime = blogCreateTime;
        return this;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public Blog setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
        return this;
    }

    public String getBlogCreatedBy() {
        return blogCreatedBy;
    }

    public Blog setBlogCreatedBy(String blogCreatedBy) {
        this.blogCreatedBy = blogCreatedBy;
        return this;
    }

    public String getBlogText() {
        return blogText;
    }

    public Blog setBlogText(String blogText) {
        this.blogText = blogText;
        return this;
    }

    public String getBlogCategory() {
        return blogCategory;
    }

    public Blog setBlogCategory(String blogCategory) {
        this.blogCategory = blogCategory;
        return this;
    }

    public String getBlogFlag() {
        return blogFlag;
    }

    public Blog setBlogFlag(String blogFlag) {
        this.blogFlag = blogFlag;
        return this;
    }

    @Override
    public String toString() {
        return "Blog{"
                + "blogId='"
                + blogId
                + '\''
                + ", blogCreateTime="
                + blogCreateTime
                + ", blogTitle='"
                + blogTitle
                + '\''
                + ", blogCreatedBy='"
                + blogCreatedBy
                + '\''
                + ", blogText='"
                + blogText
                + '\''
                + ", blogCategory='"
                + blogCategory
                + '\''
                + ", blogFlag='"
                + blogFlag
                + '\''
                + '}';
    }
}

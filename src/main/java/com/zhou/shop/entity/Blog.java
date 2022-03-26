package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 周雄
 * @date 2022/3/26 17:00
 * @description
 */
@TableName("blog")
public class Blog implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "博客id")
    @TableId(value = "blog_id", type = IdType.ASSIGN_ID)
    private String blogId;

    @ApiModelProperty(value = "博客创建时间")
    @TableField("blog_create_time")
    private LocalDateTime blogCreateTime;

    @ApiModelProperty(value = "博客标题")
    @TableField("blog_title")
    private String blogTitle;

    @ApiModelProperty(value = "博客创建人")
    @TableField("blog_create_by")
    private String blogCreatedBy;

    @ApiModelProperty(value = "博客内容")
    @TableField("blog_text")
    private String blogText;

    @ApiModelProperty(value = "博客所属栏目")
    @TableField("blog_category")
    private String blogCategory;

    @ApiModelProperty(value = "博客标签")
    @TableField("blog_flag")
    private String blogFlag;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public LocalDateTime getBlogCreateTime() {
        return blogCreateTime;
    }

    public void setBlogCreateTime(LocalDateTime blogCreateTime) {
        this.blogCreateTime = blogCreateTime;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogCreatedBy() {
        return blogCreatedBy;
    }

    public void setBlogCreatedBy(String blogCreatedBy) {
        this.blogCreatedBy = blogCreatedBy;
    }

    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

    public String getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(String blogCategory) {
        this.blogCategory = blogCategory;
    }

    public String getBlogFlag() {
        return blogFlag;
    }

    public void setBlogFlag(String blogFlag) {
        this.blogFlag = blogFlag;
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

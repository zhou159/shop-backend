package com.zhou.shop.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 周雄
 * @date 2022/3/27 14:22
 * @description
 */
@ApiModel("后端返回博客对象")
public class BlogDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("博客id")
    private String blogId;

    @ApiModelProperty("博客创建时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime blogCreateTime;

    @ApiModelProperty("博客修改时间时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime blogUpdateTime;

    @ApiModelProperty("博客标题")
    private String blogTitle;

    @ApiModelProperty("博客创建人")
    private String blogCreatedBy;

    @ApiModelProperty("博客创建人名字")
    private String blogCreatedName;

    @ApiModelProperty("博客内容")
    private String blogText;

    @ApiModelProperty("博客栏目")
    private String blogCategory;

    @ApiModelProperty("博客栏目名字")
    private String blogCategoryName;

    @ApiModelProperty("博客标签名字")
    private String blogFlagName;

    public BlogDTO() {}

    public BlogDTO(
            String blogId,
            LocalDateTime blogCreateTime,
            LocalDateTime blogUpdateTime,
            String blogTitle,
            String blogCreatedBy,
            String blogCreatedName,
            String blogText,
            String blogCategory,
            String blogCategoryName,
            String blogFlagName) {
        this.blogId = blogId;
        this.blogCreateTime = blogCreateTime;
        this.blogUpdateTime = blogUpdateTime;
        this.blogTitle = blogTitle;
        this.blogCreatedBy = blogCreatedBy;
        this.blogCreatedName = blogCreatedName;
        this.blogText = blogText;
        this.blogCategory = blogCategory;
        this.blogCategoryName = blogCategoryName;
        this.blogFlagName = blogFlagName;
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

    public LocalDateTime getBlogUpdateTime() {
        return blogUpdateTime;
    }

    public void setBlogUpdateTime(LocalDateTime blogUpdateTime) {
        this.blogUpdateTime = blogUpdateTime;
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

    public String getBlogCreatedName() {
        return blogCreatedName;
    }

    public void setBlogCreatedName(String blogCreatedName) {
        this.blogCreatedName = blogCreatedName;
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

    public String getBlogCategoryName() {
        return blogCategoryName;
    }

    public void setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName;
    }

    public String getBlogFlagName() {
        return blogFlagName;
    }

    public void setBlogFlagName(String blogFlagName) {
        this.blogFlagName = blogFlagName;
    }

    @Override
    public String toString() {
        return "BlogDTO{"
                + "blogId='"
                + blogId
                + '\''
                + ", blogCreateTime="
                + blogCreateTime
                + ", blogUpdateTime="
                + blogUpdateTime
                + ", blogTitle='"
                + blogTitle
                + '\''
                + ", blogCreatedBy='"
                + blogCreatedBy
                + '\''
                + ", blogCreatedName='"
                + blogCreatedName
                + '\''
                + ", blogText='"
                + blogText
                + '\''
                + ", blogCategory='"
                + blogCategory
                + '\''
                + ", blogCategoryName='"
                + blogCategoryName
                + '\''
                + ", blogFlagName='"
                + blogFlagName
                + '\''
                + '}';
    }
}

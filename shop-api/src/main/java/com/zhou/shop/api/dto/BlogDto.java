package com.zhou.shop.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @author 周雄
 * @date 2022/3/27 14:22
 * @description
 */
public class BlogDto {
    private String blogId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime blogCreateTime;

    private String blogTitle;

    private String blogCreatedBy;

    private String blogCreatedName;

    private String blogText;

    private String blogCategory;

    public BlogDto() {}

    public BlogDto(
            String blogId,
            LocalDateTime blogCreateTime,
            String blogTitle,
            String blogCreatedBy,
            String blogCreatedName,
            String blogText,
            String blogCategory) {
        this.blogId = blogId;
        this.blogCreateTime = blogCreateTime;
        this.blogTitle = blogTitle;
        this.blogCreatedBy = blogCreatedBy;
        this.blogCreatedName = blogCreatedName;
        this.blogText = blogText;
        this.blogCategory = blogCategory;
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

    @Override
    public String toString() {
        return "BlogDto{"
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
                + ", blogCreatedName='"
                + blogCreatedName
                + '\''
                + ", blogText='"
                + blogText
                + '\''
                + ", blogCategory='"
                + blogCategory
                + '\''
                + '}';
    }
}

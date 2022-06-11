package com.zhou.shop.api.dto;

import java.io.Serializable;

/**
 * @author 周雄
 * @date 2022/3/27 10:28
 * @description
 */
public class BlogCategoryListDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String blogCategoryId;
    private String blogCategoryName;
    private String blogCategoryDescription;
    private String blogCount;

    public BlogCategoryListDTO() {}

    public BlogCategoryListDTO(
            String blogCategoryId,
            String blogCategoryName,
            String blogCategoryDescription,
            String blogCount) {
        this.blogCategoryId = blogCategoryId;
        this.blogCategoryName = blogCategoryName;
        this.blogCategoryDescription = blogCategoryDescription;
        this.blogCount = blogCount;
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

    public String getBlogCategoryDescription() {
        return blogCategoryDescription;
    }

    public void setBlogCategoryDescription(String blogCategoryDescription) {
        this.blogCategoryDescription = blogCategoryDescription;
    }

    public String getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(String blogCount) {
        this.blogCount = blogCount;
    }

    @Override
    public String toString() {
        return "BlogCategoryListTreeDto{"
                + "blogCategoryId='"
                + blogCategoryId
                + '\''
                + ", blogCategoryName='"
                + blogCategoryName
                + '\''
                + ", blogCategoryDescription='"
                + blogCategoryDescription
                + '\''
                + ", blogCount='"
                + blogCount
                + '\''
                + '}';
    }
}

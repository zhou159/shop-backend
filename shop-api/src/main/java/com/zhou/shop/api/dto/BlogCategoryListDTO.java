package com.zhou.shop.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author 周雄
 * @date 2022/3/27 10:28
 * @description
 */
@ApiModel("博客栏目后端返回对象")
public class BlogCategoryListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("博客栏目id")
    private String blogCategoryId;

    @ApiModelProperty("博客栏目名称")
    private String blogCategoryName;

    @ApiModelProperty("博客栏目描述")
    private String blogCategoryDescription;

    @ApiModelProperty("博客栏目下博客数量")
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

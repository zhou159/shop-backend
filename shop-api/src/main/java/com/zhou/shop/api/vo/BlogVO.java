package com.zhou.shop.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zhouxiong
 * @description: 前端博客新增对象
 * @version: v1.0-2022/6/30 9:26-zhouxiong： 创建此类
 * @since 2022/6/30 9:26
 */
@ApiModel("前端博客对象")
public class BlogVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("博客id")
    private String blogId;

    @Length(min = 10,max = 100, message = "博客标题长度在10-100之间")
    @ApiModelProperty("博客标题")
    private String blogTitle;

    @NotBlank(message = "博客创建人不能为空!")
    @ApiModelProperty("博客创建人")
    private String blogCreatedBy;

    @NotBlank(message = "博客内容不能为空!")
    @ApiModelProperty("博客内容")
    private String blogText;

    @ApiModelProperty("博客所属栏目")
    private String blogCategory;

    @ApiModelProperty("博客标签")
    private String blogFlag;

    public BlogVO() {}

    public BlogVO(
            String blogId,
            String blogTitle,
            String blogCreatedBy,
            String blogText,
            String blogCategory,
            String blogFlag) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogCreatedBy = blogCreatedBy;
        this.blogText = blogText;
        this.blogCategory = blogCategory;
        this.blogFlag = blogFlag;
    }

    public String getBlogId() {
        return blogId;
    }

    public BlogVO setBlogId(String blogId) {
        this.blogId = blogId;
        return this;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public BlogVO setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
        return this;
    }

    public String getBlogCreatedBy() {
        return blogCreatedBy;
    }

    public BlogVO setBlogCreatedBy(String blogCreatedBy) {
        this.blogCreatedBy = blogCreatedBy;
        return this;
    }

    public String getBlogText() {
        return blogText;
    }

    public BlogVO setBlogText(String blogText) {
        this.blogText = blogText;
        return this;
    }

    public String getBlogCategory() {
        return blogCategory;
    }

    public BlogVO setBlogCategory(String blogCategory) {
        this.blogCategory = blogCategory;
        return this;
    }

    public String getBlogFlag() {
        return blogFlag;
    }

    public BlogVO setBlogFlag(String blogFlag) {
        this.blogFlag = blogFlag;
        return this;
    }

    @Override
    public String toString() {
        return "BlogVO{"
                + "blogTitle='"
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

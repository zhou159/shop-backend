package com.zhou.shop.apiServer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.dto.BlogCategoryListDto;
import com.zhou.shop.api.entity.blog.Blog;
import com.zhou.shop.api.entity.blog.BlogCategory;
import com.zhou.shop.apiServer.mapper.BlogCategoryMapper;
import com.zhou.shop.apiServer.mapper.BlogMapper;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.apiServer.service.IBlogCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周雄
 * @date 2022/3/26 17:23
 * @description
 */

@Service
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements IBlogCategoryService {

    private final BlogCategoryMapper blogCategoryMapper;
    private final BlogMapper blogMapper;

    private final Logger log = LoggerFactory.getLogger(BlogCategoryServiceImpl.class);

    public BlogCategoryServiceImpl(BlogCategoryMapper blogCategoryMapper, BlogMapper blogMapper) {
        this.blogCategoryMapper = blogCategoryMapper;
        this.blogMapper = blogMapper;
    }

    @Override
    public RestObject<List<BlogCategoryListDto>> queryCategoryList(String userId) {
        QueryWrapper<BlogCategory> blogCategoryQueryWrapper = new QueryWrapper<>();
        blogCategoryQueryWrapper.eq("blog_category_created_by", userId);
        List<BlogCategory> blogCategories = blogCategoryMapper.selectList(blogCategoryQueryWrapper);
        List<BlogCategoryListDto> blogCategoriesListTree = new ArrayList<>();
        for (BlogCategory blogCategory : blogCategories) {
            BlogCategoryListDto blogCategoryListTreeDto = new BlogCategoryListDto();
            BeanUtils.copyProperties(blogCategory,blogCategoryListTreeDto);
            QueryWrapper<Blog> blog = new QueryWrapper<>();
            blog.eq("blog_category", blogCategory.getBlogCategoryId());
            Long aLong = blogMapper.selectCount(blog);
            blogCategoryListTreeDto.setBlogCount(aLong.toString() + "篇");
            blogCategoriesListTree.add(blogCategoryListTreeDto);
        }
        return RestResponse.makeOkRsp(blogCategoriesListTree);
    }

    @Override
    public RestObject<BlogCategory> queryBlogCategoryById(String blogCategoryId) {
        return RestResponse.makeOkRsp(blogCategoryMapper.selectById(blogCategoryId));
    }
}

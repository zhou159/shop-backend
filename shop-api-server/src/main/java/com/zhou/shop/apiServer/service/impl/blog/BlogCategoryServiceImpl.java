package com.zhou.shop.apiServer.service.impl.blog;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.dto.BlogCategoryListDTO;
import com.zhou.shop.api.entity.blog.Blog;
import com.zhou.shop.api.entity.blog.BlogCategory;
import com.zhou.shop.apiServer.mapper.blog.BlogCategoryMapper;
import com.zhou.shop.apiServer.mapper.blog.BlogMapper;
import com.zhou.shop.apiServer.service.blog.IBlogCategoryService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
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
    public RestObject<List<BlogCategoryListDTO>> queryCategoryList(String userId) {
        List<BlogCategory> blogCategories = blogCategoryMapper.selectList(new LambdaQueryWrapper<BlogCategory>().eq(BlogCategory::getBlogCategoryCreatedBy, userId));
        List<BlogCategoryListDTO> blogCategoriesListTree = new ArrayList<>();
        for (BlogCategory blogCategory : blogCategories) {
            BlogCategoryListDTO blogCategoryListTreeDto = new BlogCategoryListDTO();
            BeanUtils.copyProperties(blogCategory, blogCategoryListTreeDto);
            Long aLong = blogMapper.selectCount(new LambdaQueryWrapper<Blog>().eq(Blog::getBlogCategory, blogCategory.getBlogCategoryId()));
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

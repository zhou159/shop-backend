package com.zhou.shop.apiServer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.dto.BlogDto;
import com.zhou.shop.api.entity.blog.Blog;
import com.zhou.shop.apiServer.mapper.BlogMapper;
import com.zhou.shop.apiServer.mapper.UserMapper;
import com.zhou.shop.apiServer.service.IBlogService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 周雄
 * @date 2022/3/26 17:22
 * @description
 */

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {
    private final BlogMapper blogMapper;
    private final UserMapper userMapper;

    private final Logger log = LoggerFactory.getLogger(BlogServiceImpl.class);

    public BlogServiceImpl(BlogMapper blogMapper, UserMapper userMapper) {
        this.blogMapper = blogMapper;
        this.userMapper = userMapper;
    }

    @Override
    public RestObject<List<BlogDto>> queryListDto() {
        List<Blog> blogs = blogMapper.selectList(null);
        return RestResponse.makeOkRsp(
                blogs.stream()
                        .map(
                                it -> {
                                    BlogDto blogDto = new BlogDto();
                                    BeanUtils.copyProperties(it, blogDto);
                                    blogDto.setBlogCreatedName(
                                            userMapper
                                                    .selectById(it.getBlogCreatedBy())
                                                    .getUsername());
                                    return blogDto;
                                })
                        .collect(Collectors.toList()));
    }

    @Override
    public RestObject<List<Blog>> queryBlogByBlogCategoryId(String blogCategoryId) {
        return RestResponse.makeOkRsp(
                blogMapper.selectList(
                        new QueryWrapper<Blog>().eq("blog_category", blogCategoryId)));
    }

    @Override
    public RestObject<BlogDto> queryById(String id) {
        Blog blog = blogMapper.selectById(id);
        BlogDto blogDto = new BlogDto();
        BeanUtils.copyProperties(blog, blogDto);
        blogDto.setBlogCreatedName(userMapper.selectById(blogDto.getBlogCreatedBy()).getUsername());
        return RestResponse.makeOkRsp(blogDto);
    }

}

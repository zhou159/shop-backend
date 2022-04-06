package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.dto.BlogDto;
import com.zhou.shop.entity.Blog;
import com.zhou.shop.mapper.BlogMapper;
import com.zhou.shop.mapper.UserMapper;
import com.zhou.shop.service.IBlogService;
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
    final BlogMapper blogMapper;
    final UserMapper userMapper;

    public BlogServiceImpl(BlogMapper blogMapper, UserMapper userMapper) {
        this.blogMapper = blogMapper;
        this.userMapper = userMapper;
    }

    @Override
    public List<BlogDto> queryListDto() {
        List<Blog> blogs = blogMapper.selectList(new QueryWrapper<Blog>().eq("1", "1"));
        List<BlogDto> collect = blogs.stream().map(it -> {
            BlogDto blogDto = new BlogDto();
            BeanUtils.copyProperties(it, blogDto);
            blogDto.setBlogCreatedName(userMapper.selectById(it.getBlogCreatedBy()).getUsername());
            return blogDto;
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<Blog> queryBlogByBlogCategoryId(String blogCategoryId) {
        List<Blog> blogs = blogMapper.selectList(new QueryWrapper<Blog>().eq("blog_category", blogCategoryId));
        return blogs;
    }

    @Override
    public BlogDto queryById(String id) {
        Blog blog = blogMapper.selectById(id);
        BlogDto blogDto = new BlogDto();
        BeanUtils.copyProperties(blog, blogDto);
        blogDto.setBlogCreatedName(userMapper.selectById(blogDto.getBlogCreatedBy()).getUsername());
        return blogDto;
    }

}

package com.zhou.shop.apiServer.service.impl.blog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.dto.BlogDTO;
import com.zhou.shop.api.entity.blog.Blog;
import com.zhou.shop.api.vo.BlogVO;
import com.zhou.shop.apiServer.common.CommonMethodStatic;
import com.zhou.shop.apiServer.common.CommonMethods;
import com.zhou.shop.apiServer.mapper.blog.BlogMapper;
import com.zhou.shop.apiServer.mapper.user.UserMapper;
import com.zhou.shop.apiServer.service.blog.IBlogService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    private final CommonMethods commonMethods;

    private final Logger log = LoggerFactory.getLogger(BlogServiceImpl.class);

    public BlogServiceImpl(
            BlogMapper blogMapper, UserMapper userMapper, CommonMethods commonMethods) {
        this.blogMapper = blogMapper;
        this.userMapper = userMapper;
        this.commonMethods = commonMethods;
    }

    @Override
    public RestObject<List<BlogDTO>> queryListDto() {
        List<Blog> blogs = blogMapper.selectList(null);
        return RestResponse.makeOkRsp(
                blogs.stream()
                        .map(
                                it -> {
                                    BlogDTO blogDto = new BlogDTO();
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
    public RestObject<BlogDTO> queryById(String id) {
        Blog blog = blogMapper.selectById(id);
        BlogDTO blogDto = new BlogDTO();
        BeanUtils.copyProperties(blog, blogDto);
        blogDto.setBlogCreatedName(userMapper.selectById(blogDto.getBlogCreatedBy()).getUsername());
        return RestResponse.makeOkRsp(blogDto);
    }

    @Override
    public RestObject<String> createBlog(BlogVO blogVO) {
        // CommonMethodStatic.checkUserId(blogVO.getBlogCreatedBy(),"用户账号信息错误!");
        final Blog blog = new Blog();
        BeanUtils.copyProperties(blogVO, blog);
        blog.setBlogCreateTime(LocalDateTime.now());
        final int insert = blogMapper.insert(blog);
        return insert > 0 ? RestResponse.makeOkRsp("发布成功!") : RestResponse.makeErrRsp("发布失败!");
    }

    @Override
    public RestObject<String> updateBlog(BlogVO blogVO) {
        // CommonMethodStatic.checkUserId(blogVO.getBlogCreatedBy(),"用户账号信息错误!");
        final Blog blog = new Blog();
        BeanUtils.copyProperties(blogVO, blog);
        blog.setBlogUpdateTime(LocalDateTime.now());
        final int i = blogMapper.updateById(blog);
        return i > 0 ? RestResponse.makeOkRsp("修改成功!") : RestResponse.makeErrRsp("修改失败!");
    }

    @Override
    public RestObject<String> deleteBlog(String blogId) {
        final Blog blog = blogMapper.selectById(blogId);
        CommonMethodStatic.checkUserId(blog.getBlogCreatedBy(), "该博客非您创建，无权删除!");
        final int i = blogMapper.deleteById(blogId);
        return i > 0 ? RestResponse.makeOkRsp("删除成功!") : RestResponse.makeErrRsp("删除失败!");
    }
}

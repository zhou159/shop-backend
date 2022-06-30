package com.zhou.shop.apply.controller.blog;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.zhou.shop.api.dto.BlogDTO;
import com.zhou.shop.api.entity.blog.Blog;
import com.zhou.shop.api.vo.BlogVO;
import com.zhou.shop.apiServer.service.blog.IBlogService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 周雄
 * @date 2022/3/26 17:27
 * @description
 */
@RestController
@RequestMapping("/blog")
@Api(tags = "博客")
public class BlogController {
    private final IBlogService blogService;

    public BlogController(IBlogService blogService){
        this.blogService = blogService;
    }

    @ApiOperation("查询所有博客")
    @GetMapping("/getAllBlog")
    public RestObject<List<BlogDTO>> queryAllBlog(){
        return blogService.queryListDto();
    }

    @ApiOperation(value = "根据博客id查询博客")
    @GetMapping("/getBlogById/{blogId}")
    public RestObject<BlogDTO> queryById(@PathVariable("blogId") String blogId) {
        return blogService.queryById(blogId);
    }

    @ApiOperation(value = "根据博客栏目id查询博客栏目")
    @GetMapping("/getBlogByBlogCategoryId/{blogCategoryId}")
    public RestObject<List<Blog>> queryBlogByBlogCategoryId(@PathVariable("blogCategoryId") String blogCategoryId){
        return blogService.queryBlogByBlogCategoryId(blogCategoryId);
    }

    @SaCheckLogin
    @ApiOperation(value = "新增博客")
    @PostMapping("/createBlog")
    public RestObject<String> createBlog(@Valid @RequestBody BlogVO blogVO) {
        return blogService.createBlog(blogVO);
    }

    @SaCheckLogin
    @ApiOperation(value = "修改博客")
    @PostMapping("/updateBlog")
    public RestObject<String> updateBlog(@Valid @RequestBody BlogVO blogVO) {
        return blogService.updateBlog(blogVO);
    }

    @SaCheckLogin
    @ApiOperation(value = "删除博客")
    @PostMapping("/deletedBlog")
    public RestObject<String> deleteBlog(String blogId) {
        return blogService.deleteBlog(blogId);
    }
}

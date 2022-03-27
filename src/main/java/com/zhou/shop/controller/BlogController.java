package com.zhou.shop.controller;

import com.zhou.shop.dto.BlogDto;
import com.zhou.shop.entity.Blog;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IBlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 周雄
 * @date 2022/3/26 17:27
 * @description
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    final IBlogService blogService;

    public BlogController(IBlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("/getAllBlog")
    public RestObject<List<BlogDto>> queryAllBlog(){
        return RestResponse.makeOkRsp(blogService.queryListDto());
    }

    @GetMapping("/getBlogById/{blogId}")
    public RestObject<Blog> queryById(@PathVariable("blogId") String id){
        return RestResponse.makeOkRsp(blogService.getById(id));
    }

    @GetMapping("/getBlogByBlogCategoryId/{blogCategoryId}")
    public RestObject<List<Blog>> queryBlogByBlogCategoryId(@PathVariable("blogCategoryId") String blogCategoryId){
        return RestResponse.makeOkRsp(blogService.queryBlogByBlogCategoryId(blogCategoryId));
    }
}

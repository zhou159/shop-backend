package com.zhou.shop.apply.controller;

import com.zhou.shop.api.dto.BlogCategoryListDto;
import com.zhou.shop.api.entity.blog.BlogCategory;
import com.zhou.shop.apiServer.service.IBlogCategoryService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 周雄
 * @date 2022/3/26 17:54
 * @description
 */
@RestController
@RequestMapping("/blogCategory")
@Api(tags = "博客栏目")
public class BlogCategoryController {
    private final IBlogCategoryService blogCategoryService;

    public BlogCategoryController(IBlogCategoryService blogCategoryService) {
        this.blogCategoryService = blogCategoryService;
    }

    @GetMapping("/queryBlogCategoryListByUserId/{userId}")
    @ApiOperation("根据用户id查询博客栏目列表")
    public RestObject<List<BlogCategoryListDto>> queryCategoryListByUserId(@PathVariable("userId") String userId){
        return blogCategoryService.queryCategoryList(userId);
    }

    @GetMapping("/queryBlogCategoryById/{blogCategoryId}")
    public RestObject<BlogCategory> queryBlogCategoryById(
            @PathVariable("blogCategoryId") String blogCategoryId) {
        return blogCategoryService.queryBlogCategoryById(blogCategoryId);
    }
}

package com.zhou.shop.controller;

import com.zhou.shop.dto.BlogCategoryListDto;
import com.zhou.shop.entity.BlogCategory;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IBlogCategoryService;
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
public class BlogCategoryController {
    final IBlogCategoryService blogCategoryService;

    public BlogCategoryController(IBlogCategoryService blogCategoryService) {
        this.blogCategoryService = blogCategoryService;
    }

    @GetMapping("/queryBlogCategoryListByUserId/{userId}")
    public RestObject<List<BlogCategoryListDto>> queryCategoryListByUserId(@PathVariable("userId") String userId){
        return RestResponse.makeOkRsp(blogCategoryService.queryCategoryList(userId));
    }

    @GetMapping("/queryBlogCategoryById/{blogCategoryId}")
    public RestObject<BlogCategory> queryBlogCategoryById(@PathVariable("blogCategoryId")String blogCategoryId){
        return RestResponse.makeOkRsp(blogCategoryService.getById(blogCategoryId));
    }
}

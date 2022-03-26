package com.zhou.shop.controller;

import com.zhou.shop.service.IBlogCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

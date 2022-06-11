package com.zhou.shop.apply.controller.blog;

import com.zhou.shop.api.dto.BlogDTO;
import com.zhou.shop.api.entity.blog.Blog;
import com.zhou.shop.apiServer.service.blog.IBlogService;
import com.zhou.shop.common.RestObject;
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
    private final IBlogService blogService;

    public BlogController(IBlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("/getAllBlog")
    public RestObject<List<BlogDTO>> queryAllBlog(){
        return blogService.queryListDto();
    }

    @GetMapping("/getBlogById/{blogId}")
    public RestObject<BlogDTO> queryById(@PathVariable("blogId") String blogId) {
        return blogService.queryById(blogId);
    }

    @GetMapping("/getBlogByBlogCategoryId/{blogCategoryId}")
    public RestObject<List<Blog>> queryBlogByBlogCategoryId(@PathVariable("blogCategoryId") String blogCategoryId){
        return blogService.queryBlogByBlogCategoryId(blogCategoryId);
    }
}

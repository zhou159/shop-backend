package com.zhou.shop.apiServer.service.blog;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.dto.BlogDto;
import com.zhou.shop.api.entity.blog.Blog;
import com.zhou.shop.common.RestObject;

import java.util.List;

/**
 * @author 周雄
 * @date 2022/3/26 17:20
 * @description
 */
public interface IBlogService extends IService<Blog> {
    /**
     * 根据用户id获取Dto对象列表
     *
     * @return
     */
    RestObject<List<BlogDto>> queryListDto();

    /**
     * 根据栏目id获取blogDto对象列表
     *
     * @param blogCategoryId
     * @return
     */
    RestObject<List<Blog>> queryBlogByBlogCategoryId(String blogCategoryId);

    /**
     * 根据博客id获取对象
     *
     * @param id
     * @return
     */
    RestObject<BlogDto> queryById(String id);
}

package com.zhou.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.dto.BlogDto;
import com.zhou.shop.entity.Blog;

import java.util.List;

/**
 * @author 周雄
 * @date 2022/3/26 17:20
 * @description
 */
public interface IBlogService extends IService<Blog> {
    /**
     * 根据用户id获取Dto对象列表
     * @return
     */
    List<BlogDto> queryListDto();

    /**
     * 根据栏目id获取blogDto对象列表
     * @param blogCategoryId
     * @return
     */
    List<Blog> queryBlogByBlogCategoryId(String blogCategoryId);
}

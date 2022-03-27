package com.zhou.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.dto.BlogCategoryListDto;
import com.zhou.shop.entity.BlogCategory;

import java.util.List;

/**
 * @author 周雄
 * @date 2022/3/26 17:21
 * @description
 */
public interface IBlogCategoryService extends IService<BlogCategory> {
    /**
     * 根据用户id获取
     * @param userId
     * @return
     */
    List<BlogCategoryListDto> queryCategoryList(String userId);
}

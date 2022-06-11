package com.zhou.shop.apiServer.service.blog;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.dto.BlogCategoryListDTO;
import com.zhou.shop.api.entity.blog.BlogCategory;
import com.zhou.shop.common.RestObject;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author 周雄
 * @date 2022/3/26 17:21
 * @description
 */
public interface IBlogCategoryService extends IService<BlogCategory> {
    /**
     * 根据用户id获取
     *
     * @param userId
     * @return
     */
    RestObject<List<BlogCategoryListDTO>> queryCategoryList(String userId);

    /**
     * 根据id查询
     *
     * @param blogCategoryId id
     * @return
     */
    RestObject<BlogCategory> queryBlogCategoryById(
            @PathVariable("blogCategoryId") String blogCategoryId);
}

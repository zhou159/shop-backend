package com.zhou.shop.apiServer.service.blog;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.dto.BlogDTO;
import com.zhou.shop.api.entity.blog.Blog;
import com.zhou.shop.api.vo.BlogVO;
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
     * @return 博客集合
     */
    RestObject<List<BlogDTO>> queryListDto();

    /**
     * 根据栏目id获取blogDto对象列表
     *
     * @param blogCategoryId 博客栏目id
     * @return 该栏目下博客集合
     */
    RestObject<List<Blog>> queryBlogByBlogCategoryId(String blogCategoryId);

    /**
     * 根据博客id获取对象
     *
     * @param id 博客id
     * @return 博客对象
     */
    RestObject<BlogDTO> queryById(String id);

    /**
     * 新建博客
     *
     * @param blogVO 前端传入新增博客对象
     * @return 信息
     */
    RestObject<String> createBlog(BlogVO blogVO);

    /**
     * 修改博客
     *
     * @param blogVO 前端传入博客对象
     * @return 信息
     */
    RestObject<String> updateBlog(BlogVO blogVO);

    /**
     * 删除博客
     *
     * @param blogId 前端传入博客id
     * @return 信息
     */
    RestObject<String> deleteBlog(String blogId);
}

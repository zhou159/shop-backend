package com.zhou.shop.apiServer.mapper.blog;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.api.dto.BlogDTO;
import com.zhou.shop.api.entity.blog.Blog;
import com.zhou.shop.apiServer.provider.BlogProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author 周雄
 * @date 2022/3/26 17:19
 * @description
 */
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
    @SelectProvider(type = BlogProvider.class ,method = "queryAllBlog")
    List<BlogDTO> queryAllBlog();

    @SelectProvider(type = BlogProvider.class ,method = "queryAllByBlogCategoryId")
    List<BlogDTO> queryAllByBlogCategoryId(String blogCategoryId);

}

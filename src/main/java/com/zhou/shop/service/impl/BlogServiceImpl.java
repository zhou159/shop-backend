package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.Blog;
import com.zhou.shop.mapper.BlogMapper;
import com.zhou.shop.service.IBlogService;
import org.springframework.stereotype.Service;

/**
 * @author 周雄
 * @date 2022/3/26 17:22
 * @description
 */

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {}

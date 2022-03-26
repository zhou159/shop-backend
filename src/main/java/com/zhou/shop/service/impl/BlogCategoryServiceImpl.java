package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.BlogCategory;
import com.zhou.shop.mapper.BlogCategoryMapper;
import com.zhou.shop.service.IBlogCategoryService;
import org.springframework.stereotype.Service;

/**
 * @author 周雄
 * @date 2022/3/26 17:23
 * @description
 */

@Service
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements IBlogCategoryService {}

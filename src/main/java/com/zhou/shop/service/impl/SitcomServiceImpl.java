package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.Sitcom;
import com.zhou.shop.mapper.SitcomMapper;
import com.zhou.shop.service.ISitcomService;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-08-21
 */
@Service
public class SitcomServiceImpl extends ServiceImpl<SitcomMapper, Sitcom>
        implements ISitcomService {}

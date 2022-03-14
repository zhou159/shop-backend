package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.Sitcom;
import com.zhou.shop.mapper.SitcomMapper;
import com.zhou.shop.service.ISitcomService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-08-21
 */
@Service
public class SitcomServiceImpl extends ServiceImpl<SitcomMapper, Sitcom>
        implements ISitcomService {
    @Override
    public boolean save(Sitcom entity) {
        return false;
    }

    @Override
    public boolean removeById(Sitcom entity) {
        return super.removeById(entity);
    }

    @Override
    public boolean updateById(Sitcom entity) {
        return false;
    }

    @Override
    public List<Sitcom> list(Wrapper<Sitcom> queryWrapper){
        return super.list(queryWrapper);
    }

    @Override
    public Sitcom getById(Serializable id){
        return super.getById(id);
    }
}

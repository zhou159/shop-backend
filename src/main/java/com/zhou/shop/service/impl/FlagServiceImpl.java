package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.Flag;
import com.zhou.shop.mapper.FlagMapper;
import com.zhou.shop.service.IFlagService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Service
public class FlagServiceImpl extends ServiceImpl<FlagMapper, Flag> implements IFlagService {
    final FlagMapper flagMapper;

    public FlagServiceImpl(FlagMapper flagMapper) {
        this.flagMapper = flagMapper;
    }

    @Override
    public boolean save(Flag entity) {
        return false;
    }

    @Override
    public boolean removeById(Flag entity) {
        return super.removeById(entity);
    }

    @Override
    public boolean updateById(Flag entity) {
        return false;
    }

    @Override
    public List<Flag> list(Wrapper<Flag> queryWrapper){
        return super.list(queryWrapper);
    }

    @Override
    public Flag getById(Serializable id){
        return super.getById(id);
    }

    @Override
    public Flag retrieveByFlagName(String flagName) {
        return flagMapper.retrieveByFlagName(flagName);
    }
}

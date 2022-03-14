package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.Unit;
import com.zhou.shop.mapper.UnitMapper;
import com.zhou.shop.service.IUnitService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-07-20
 */
@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit> implements IUnitService {

    final UnitMapper unitMapper;

    public UnitServiceImpl(UnitMapper unitMapper) {
        this.unitMapper = unitMapper;
    }

    @Override
    public boolean save(Unit entity) {
        return false;
    }

    @Override
    public boolean removeById(Unit entity) {
        return super.removeById(entity);
    }

    @Override
    public boolean updateById(Unit entity) {
        return false;
    }

    @Override
    public List<Unit> list(Wrapper<Unit> queryWrapper){
        return super.list(queryWrapper);
    }

    @Override
    public Unit getById(Serializable id){
        return super.getById(id);
    }

    @Override
    public List<Unit> retrieveByUnitName(String unitName) {
        return unitMapper.retrieveByUnitName(unitName);
    }
}

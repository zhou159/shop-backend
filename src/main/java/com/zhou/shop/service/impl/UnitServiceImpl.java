package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.Unit;
import com.zhou.shop.mapper.UnitMapper;
import com.zhou.shop.service.IUnitService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
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
    public List<Unit> retrieveByUnitName(String unitName) {
        return unitMapper.retrieveByUnitName(unitName);
    }
}

package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.Shop;
import com.zhou.shop.entity.Unit;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 周雄
 * @since 2021-07-20
 */
public interface IUnitService extends IService<Unit> {

    @Override
    boolean save(Unit entity);

    @Override
    boolean removeById(Serializable id);

    @Override
    boolean updateById(Unit entity);

    @Override
    Unit getById(Serializable id);

    @Override
    List<Unit> list(Wrapper<Unit> queryWrapper);

    List<Unit> retrieveByUnitName(String unitName);
}

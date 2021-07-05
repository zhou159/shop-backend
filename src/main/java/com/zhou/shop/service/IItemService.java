package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.zhou.shop.entity.Item;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 周雄
 * @since 2021-06-24
 */
public interface IItemService extends IService<Item> {
    @Override
    boolean save(Item entity);

    @Override
    boolean removeById(Serializable id);

    @Override
    boolean updateById(Item entity);

    @Override
    Item getById(Serializable id);

    @Override
    List<Item> list(Wrapper<Item> queryWrapper);
}

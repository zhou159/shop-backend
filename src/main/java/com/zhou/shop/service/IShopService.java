package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.zhou.shop.dto.ItemDto;
import com.zhou.shop.entity.Flag;
import com.zhou.shop.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.User;

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
public interface IShopService extends IService<Shop> {

    @Override
    boolean save(Shop entity);

    @Override
    boolean removeById(Serializable id);

    @Override
    boolean updateById(Shop entity);

    @Override
    Shop getById(Serializable id);

    @Override
    List<Shop> list(Wrapper<Shop> queryWrapper);

    List<Shop> retrieveByShopName(String shopName);
}

package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.Shop;

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
    /**
     * 新增商店
     * @param entity 商店对象
     * @return 布尔值
     */
    @Override
    boolean save(Shop entity);

    /**
     * 按id删除商店
     * @param id 商店id
     * @return 布尔值
     */
    @Override
    boolean removeById(Serializable id);

    /**
     * 按id修改商店数据
     * @param entity 商品对象
     * @return 布尔值
     */
    @Override
    boolean updateById(Shop entity);

    /**
     * 按id查询商店
     * @param id 商店id
     * @return 商店对象
     */
    @Override
    Shop getById(Serializable id);

    /**
     * 查询全部商店
     * @param queryWrapper 查询构造条件
     * @return 数组，全部商店
     */
    @Override
    List<Shop> list(Wrapper<Shop> queryWrapper);

    /**
     * 按商店名查询商品
     * @param shopName 商店名
     * @return 商店对象
     */
    List<Shop> retrieveByShopName(String shopName);
}

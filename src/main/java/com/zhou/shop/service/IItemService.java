package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.dto.ItemDto;
import com.zhou.shop.entity.Item;

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
    /**
     * 新增商品
     * @param entity 商品对象
     * @return 布尔值
     */
    @Override
    boolean save(Item entity);

    /**
     * 按id删除商品
     * @param id 商品id
     * @return 布尔值
     */
    @Override
    boolean removeById(Serializable id);

    /**
     * 按id修改商品信息
     * @param entity 商品id
     * @return 布尔值
     */
    @Override
    boolean updateById(Item entity);

    /**
     * 按id查询商品
     * @param id 商品id
     * @return 商品对象
     */
    @Override
    Item getById(Serializable id);

    /**
     * 查询全部商品
     * @param queryWrapper 查询构造条件
     * @return 数组，全部商品
     */
    @Override
    List<Item> list(Wrapper<Item> queryWrapper);

    /**
     * 查询全部商品
     * @return 商品dto对象
     */
    List<ItemDto> retrieveAllItem();

    /**
     * 按商品名查询商品
     * @param itemName 商品名
     * @return 商品dto对象
     */
    List<ItemDto> retrieveByItemName(String itemName);
}

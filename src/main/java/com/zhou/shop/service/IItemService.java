package com.zhou.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.dto.ItemDto;
import com.zhou.shop.entity.Item;

import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-06-24
 */
public interface IItemService extends IService<Item> {
    /**
     * 查询全部商品
     *
     * @return 商品dto对象
     */
    List<ItemDto> retrieveAllItem();

    /**
     * 按商品名查询商品
     *
     * @param itemName 商品名
     * @return 商品dto对象
     */
    List<ItemDto> retrieveByItemName(String itemName);
}

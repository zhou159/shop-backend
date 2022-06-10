package com.zhou.shop.apiServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.dto.ItemDto;
import com.zhou.shop.api.entity.privates.Item;
import com.zhou.shop.api.vo.ItemVo;
import com.zhou.shop.common.RestObject;

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
    RestObject<List<ItemDto>> retrieveAllItem();

    /**
     * 按商品名查询商品
     *
     * @param itemName 商品名
     * @return 商品dto对象
     */
    RestObject<List<ItemDto>> retrieveByItemName(String itemName);

    /**
     * 新增
     *
     * @param itemVo 前端传入对象
     * @return
     */
    RestObject<String> createItem(ItemVo itemVo);

    /**
     * 根据id查询
     *
     * @param itemId id
     * @return
     */
    RestObject<Item> retrieveByItemId(String itemId);

    /**
     * 根据id修改
     *
     * @param itemId id
     * @param itemVo 前端对象
     * @return
     */
    RestObject<String> updateItemByItemId(String itemId, ItemVo itemVo);

    /**
     * 根据id删除
     *
     * @param itemId id
     * @return
     */
    RestObject<String> deleteItemById(String itemId);
}

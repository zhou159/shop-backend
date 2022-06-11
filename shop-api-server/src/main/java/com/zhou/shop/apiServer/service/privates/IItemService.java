package com.zhou.shop.apiServer.service.privates;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.dto.ItemDTO;
import com.zhou.shop.api.entity.privates.Item;
import com.zhou.shop.api.vo.ItemVO;
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
    RestObject<List<ItemDTO>> retrieveAllItem();

    /**
     * 按商品名查询商品
     *
     * @param itemName 商品名
     * @return 商品dto对象
     */
    RestObject<List<ItemDTO>> retrieveByItemName(String itemName);

    /**
     * 新增
     *
     * @param itemVo 前端传入对象
     * @return
     */
    RestObject<String> createItem(ItemVO itemVo);

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
    RestObject<String> updateItemByItemId(String itemId, ItemVO itemVo);

    /**
     * 根据id删除
     *
     * @param itemId id
     * @return
     */
    RestObject<String> deleteItemById(String itemId);
}

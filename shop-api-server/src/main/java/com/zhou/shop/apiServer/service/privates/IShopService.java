package com.zhou.shop.apiServer.service.privates;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.entity.privates.Shop;
import com.zhou.shop.common.RestObject;

import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-06-24
 */
public interface IShopService extends IService<Shop> {
    /**
     * 按商店名查询商品
     *
     * @param shopName 商店名
     * @param userId 用户id
     * @return 商店对象
     */
    RestObject<List<Shop>> retrieveByShopName(String userId, String shopName);

    /**
     * 新增
     *
     * @param shop 对象
     * @return
     */
    RestObject<String> createShop(Shop shop);

    /**
     * 根据id查询
     *
     * @param shopId id
     * @return
     */
    RestObject<Shop> retrieveByShopId(String shopId);

    /**
     * 查询全部
     *
     * @return
     */
    RestObject<List<Shop>> retrieveAllShop(String userId);

    /**
     * 根据id修改
     *
     * @param shop 对象
     * @return
     */
    RestObject<String> updateShopByShopId(Shop shop);

    /**
     * 根据id删除
     *
     * @param shopId id
     * @return
     */
    RestObject<String> deleteShopById(String shopId);
}

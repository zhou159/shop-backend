package com.zhou.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.Shop;

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
     * @return 商店对象
     */
    List<Shop> retrieveByShopName(String shopName);
}

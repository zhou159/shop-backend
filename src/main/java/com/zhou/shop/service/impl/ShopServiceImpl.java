package com.zhou.shop.service.impl;

import com.zhou.shop.entity.Shop;
import com.zhou.shop.mapper.ShopMapper;
import com.zhou.shop.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Autowired
    ShopMapper shopMapper;

    @Override
    public List<Shop> retrieveByShopName(String shopName) {
        return shopMapper.retrieveByShopName(shopName);
    }
}

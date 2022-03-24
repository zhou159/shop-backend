package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.Shop;
import com.zhou.shop.mapper.ShopMapper;
import com.zhou.shop.service.IShopService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    final ShopMapper shopMapper;

    public ShopServiceImpl(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    @Override
    public boolean save(Shop entity) {
        return super.save(entity);
    }

    @Override
    public boolean removeById(Shop entity) {
        return super.removeById(entity);
    }

    @Override
    public boolean updateById(Shop entity) {
        return super.updateById(entity);
    }

    @Override
    public List<Shop> list(Wrapper<Shop> queryWrapper){
        return super.list(queryWrapper);
    }

    @Override
    public Shop getById(Serializable id){
        return super.getById(id);
    }

    @Override
    public List<Shop> retrieveByShopName(String shopName) {
        return shopMapper.retrieveByShopName(shopName);
    }
}

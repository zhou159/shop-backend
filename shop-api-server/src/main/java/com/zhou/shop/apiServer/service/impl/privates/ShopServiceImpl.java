package com.zhou.shop.apiServer.service.impl.privates;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.privates.Shop;
import com.zhou.shop.apiServer.mapper.privates.ShopMapper;
import com.zhou.shop.apiServer.service.privates.IShopService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.common.exception.ShopException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    private final ShopMapper shopMapper;

    private final Logger log = LoggerFactory.getLogger(ShopServiceImpl.class);

    public ShopServiceImpl(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    @Override
    public RestObject<List<Shop>> retrieveByShopName(String userId, String shopName) {
        return RestResponse.makeOkRsp(
                shopMapper.selectList(
                        new LambdaQueryWrapper<Shop>()
                                .like(Shop::getShopName, shopName)
                                .eq(Shop::getUserId, userId)));
    }

    @Override
    public RestObject<String> createShop(Shop shop) {
        shop.setShopCreateTime(LocalDateTime.now());
        int insert = shopMapper.insert(shop);
        if (insert < 1) {
            log.warn("新增商店失败！");
            throw new ShopException("新增失败！");
        }
        log.info("新增商店成功！");
        return RestResponse.makeOkRsp("新增成功!");
    }

    @Override
    public RestObject<Shop> retrieveByShopId(String shopId) {
        return RestResponse.makeOkRsp(shopMapper.selectById(shopId));
    }

    @Override
    public RestObject<List<Shop>> retrieveAllShop(String userId) {
        return RestResponse.makeOkRsp(
                shopMapper.selectList(new LambdaQueryWrapper<Shop>().eq(Shop::getUserId, userId)));
    }

    @Override
    public RestObject<String> updateShopByShopId(Shop shop) {
        shop.setShopUpdateTime(LocalDateTime.now());
        int i = shopMapper.updateById(shop);
        if (i < 1) {
            log.warn("修改商店失败！商店id:" + shop.getShopId());
            throw new ShopException("修改失败！");
        }
        log.info("修改商店成功！商店id:" + shop.getShopId());
        return RestResponse.makeOkRsp("修改成功！");
    }

    @Override
    public RestObject<String> deleteShopById(String shopId) {
        int i = shopMapper.deleteById(shopId);
        if (i < 1) {
            log.warn("删除商店失败！商店id:" + shopId);
            throw new ShopException("删除失败！");
        }
        log.info("删除商店成功！商店id:" + shopId);
        return RestResponse.makeOkRsp("删除成功！");
    }
}

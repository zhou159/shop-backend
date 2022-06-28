package com.zhou.shop.apply.controller.privates;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zhou.shop.api.entity.privates.Shop;
import com.zhou.shop.apiServer.service.privates.IShopService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前端控制器
 *
 * @author 周雄
 * @since 2021-06-24
 */
@SaCheckRole("superAdmin")
@RestController
@RequestMapping("/shop")
@Api(tags = "商店")
public class ShopController {
    private final IShopService iShopService;

    public ShopController(IShopService iShopService) {
        this.iShopService = iShopService;
    }

    @ApiOperation("新增商店")
    @PostMapping("/createShop")
    public RestObject<String> createShop(@RequestBody Shop shop) {
        return iShopService.createShop(shop);
    }

    @ApiOperation("按id查询商店")
    @GetMapping("/retrieveByShopId/{shopId}")
    public RestObject<Shop> retrieveByShopId(@PathVariable String shopId) {
        return iShopService.retrieveByShopId(shopId);
    }

    @ApiOperation("查询全部商店")
    @GetMapping("/retrieveAllShop/{userId}")
    public RestObject<List<Shop>> retrieveAllShop(@PathVariable("userId")String userId) {
        return iShopService.retrieveAllShop(userId);
    }

    @ApiOperation("按id修改商店")
    @PostMapping("/updateShopByShopId")
    public RestObject<String> updateShopByShopId(@RequestBody Shop shop) {
        return iShopService.updateShopByShopId(shop);
    }

    @ApiOperation("按id删除商店")
    @PostMapping("/deleteByShopId/{shopId}")
    public RestObject<String> deleteShopById(@PathVariable String shopId) {
        return iShopService.deleteShopById(shopId);
    }

    @ApiOperation("按商店名称查询")
    @PostMapping("/retrieveByShopName")
    public RestObject<List<Shop>> retrieveShopByShopName(@RequestBody Shop shop) {
        return iShopService.retrieveByShopName(shop.getUserId(), shop.getShopName());
    }
}

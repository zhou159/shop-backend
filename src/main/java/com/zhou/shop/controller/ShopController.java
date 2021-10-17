package com.zhou.shop.controller;

import com.zhou.shop.entity.Shop;
import com.zhou.shop.enums.LogStatus;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IShopService;
import com.zhou.shop.util.LogUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 前端控制器
 *
 * @author 周雄
 * @since 2021-06-24
 */
@RestController
@RequestMapping("/shop")
public class ShopController {
    final IShopService iShopService;
    final LogUtil logUtil;

    public ShopController(IShopService iShopService, LogUtil logUtil) {
        this.iShopService = iShopService;
        this.logUtil = logUtil;
    }

    @ApiOperation("新增商店")
    @PostMapping("/createShop")
    public RestObject<String> createShop(@RequestBody Shop shop) {
        shop.setShopId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
        boolean save = iShopService.save(shop);
        if (save) {
            logUtil.log("新增商店成功", LogStatus.INFO.info);
            return RestResponse.makeOkRsp("新增成功！");
        } else {
            logUtil.log("新增商店出现异常", LogStatus.ERROR.info);
            return RestResponse.makeErrRsp("新增失败！");
        }
    }

    @ApiOperation("按id查询商店")
    @GetMapping("/retrieveByShopId/{shopId}")
    public RestObject<Shop> retrieveByShopId(@PathVariable String shopId) {
        Shop shop = iShopService.getById(shopId);
        logUtil.log("查询了商店信息，商店ID：" + shopId, LogStatus.INFO.info);
        return RestResponse.makeOkRsp(shop);
    }

    @ApiOperation("查询全部商店")
    @GetMapping("/retrieveAllShop")
    public RestObject<List<Shop>> retrieveAllShop() {
        List<Shop> list = iShopService.list();
        logUtil.log("查询了全部商店信息", LogStatus.INFO.info);
        return RestResponse.makeOkRsp(list);
    }

    @ApiOperation("按id修改商店")
    @PostMapping("/updateShopByShopId/{shopId}")
    public RestObject<String> updateShopByShopId(
            @PathVariable String shopId, @RequestBody Shop shop) {
        shop.setShopId(shopId);
        boolean b = iShopService.updateById(shop);
        if (b) {
            logUtil.log("成功修改了商店信息，商店ID：" + shopId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("修改成功！");
        } else {
            logUtil.log("修改商店信息时失败，商店ID：" + shopId, LogStatus.ERROR.info);
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @ApiOperation("按id删除商店")
    @PostMapping("/deleteByShopId/{shopId}")
    public RestObject<String> deleteShopById(@PathVariable String shopId) {
        boolean b = iShopService.removeById(shopId);
        if (b) {
            logUtil.log("成功删除了商店信息，商店ID：" + shopId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("删除成功！");
        } else {
            logUtil.log("删除商店信息时失败，商店ID：" + shopId, LogStatus.ERROR.info);
            return RestResponse.makeErrRsp("删除失败！");
        }
    }

    @ApiOperation("按商店名称查询")
    @PostMapping("/retrieveByShopName")
    public RestObject<List<Shop>> retrieveShopByShopName(@RequestBody Shop shop) {
        List<Shop> list = iShopService.retrieveByShopName(shop.getShopName());
        logUtil.log("按名查询了商店信息，商店名：" + shop.getShopName(), LogStatus.INFO.info);
        return RestResponse.makeOkRsp(list);
    }
}

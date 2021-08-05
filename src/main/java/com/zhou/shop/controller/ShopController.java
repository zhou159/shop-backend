package com.zhou.shop.controller;

import com.zhou.shop.entity.Shop;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IShopService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 周雄
 * @since 2021-06-24
 */
@RestController
@RequestMapping("/shop")
public class ShopController {
    final IShopService iShopService;

    public ShopController(IShopService iShopService) {
        this.iShopService = iShopService;
    }

    @PostMapping("/createShop")
    public RestObject<String> createShop(@RequestBody Shop shop){
        boolean save = iShopService.save(shop);
        if (save){
            return RestResponse.makeOkRsp("新增成功！");
        }else {
            return RestResponse.makeErrRsp("新增成功！");
        }
    }

    @GetMapping("/retrieveByShopId/{shopId}")
    public RestObject<Shop> retrieveByShopId(@PathVariable int shopId){
        Shop shop = iShopService.getById(shopId);
        return RestResponse.makeOkRsp(shop);
    }

    @GetMapping("/retrieveAllShop")
    public RestObject<List<Shop>> retrieveAllShop (){
        List<Shop> list = iShopService.list();
        return RestResponse.makeOkRsp(list);
    }

    @PostMapping("/updateShopByShopId/{shopId}")
    public RestObject<String> updateShopByShopId(@PathVariable int shopId,@RequestBody Shop shop){
        shop.setShopId(shopId);
        boolean b = iShopService.updateById(shop);
        if (b){
            return RestResponse.makeOkRsp("修改成功！");
        }else {
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @PostMapping("/deleteByShopId/{shopId}")
    public RestObject<String> deleteShopById(@PathVariable int shopId){
        boolean b = iShopService.removeById(shopId);
        if (b){
            return RestResponse.makeOkRsp("删除成功！");
        }else {
            return RestResponse.makeErrRsp("删除失败！");
        }
    }

    @ApiOperation("按商店名称查询")
    @PostMapping("/retrieveByShopName")
    public RestObject<List<Shop>> retrieveShopByShopName (@RequestBody Shop shop){
        List<Shop> list = iShopService.retrieveByShopName(shop.getShopName());
        return RestResponse.makeOkRsp(list);
    }
}
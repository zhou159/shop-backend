package com.zhou.shop.controller;

import com.zhou.shop.dto.ItemDto;
import com.zhou.shop.entity.Item;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.service.IFlagService;
import com.zhou.shop.service.IItemService;
import com.zhou.shop.vo.ItemVo;
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
@Api("商品")
@RestController
@RequestMapping("/item")
public class ItemController {

    final IItemService iItemService;
    final IFlagService iFlagService;

    public ItemController(IItemService iItemService, IFlagService iFlagService) {
        this.iItemService = iItemService;
        this.iFlagService = iFlagService;
    }

    @ApiOperation("新建商品")
    @PostMapping("/createItem")
    public RestObject<String> createItem(@RequestBody ItemVo itemVo) {
        return iItemService.createItem(itemVo);
    }

    @ApiOperation("按商品id查询")
    @GetMapping("/retrieveByItemId/{itemId}")
    public RestObject<Item> retrieveByItemId(@PathVariable String itemId) {
        return iItemService.retrieveByItemId(itemId);
    }

    @ApiOperation("查询全部商品")
    @GetMapping("/retrieveAllItem")
    public RestObject<List<ItemDto>> retrieveAllItem() {
        return iItemService.retrieveAllItem();
    }

    @ApiOperation("按商品id更新")
    @PostMapping("/updateItemByItemId/{itemId}")
    public RestObject<String> updateItemByItemId(@PathVariable String itemId, @RequestBody ItemVo itemVo) {
        return iItemService.updateItemByItemId(itemId, itemVo);
    }

    @ApiOperation("按商品id删除")
    @PostMapping("/deleteByItemId/{itemId}")
    public RestObject<String> deleteItemById(@PathVariable String itemId) {
        return iItemService.deleteItemById(itemId);
    }

    @ApiOperation("按商品名称查询")
    @PostMapping("/retrieveByItemName")
    public RestObject<List<ItemDto>> retrieveItemByItemName(@RequestBody Item item) {
        return iItemService.retrieveByItemName(item.getItemName());
    }
}

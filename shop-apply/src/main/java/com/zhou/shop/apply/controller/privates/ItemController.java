package com.zhou.shop.apply.controller.privates;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zhou.shop.api.dto.ItemDTO;
import com.zhou.shop.api.entity.privates.Item;
import com.zhou.shop.api.vo.ItemVO;
import com.zhou.shop.apiServer.service.IFlagService;
import com.zhou.shop.apiServer.service.privates.IItemService;
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
@Api(tags = "商品")
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
    public RestObject<String> createItem(@RequestBody ItemVO itemVo) {
        return iItemService.createItem(itemVo);
    }

    @ApiOperation("按商品id查询")
    @GetMapping("/retrieveByItemId/{itemId}")
    public RestObject<Item> retrieveByItemId(@PathVariable String itemId) {
        return iItemService.retrieveByItemId(itemId);
    }

    @ApiOperation("查询全部商品")
    @GetMapping("/retrieveAllItem/{userId}")
    public RestObject<List<ItemDTO>> retrieveAllItem(@PathVariable("userId")String userId) {
        return iItemService.retrieveAllItem(userId);
    }

    @ApiOperation("按商品id更新")
    @PostMapping("/updateItemByItemId/{itemId}")
    public RestObject<String> updateItemByItemId(@PathVariable String itemId, @RequestBody ItemVO itemVo) {
        return iItemService.updateItemByItemId(itemId, itemVo);
    }

    @ApiOperation("按商品id删除")
    @PostMapping("/deleteByItemId/{itemId}")
    public RestObject<String> deleteItemById(@PathVariable String itemId) {
        return iItemService.deleteItemById(itemId);
    }

    @ApiOperation("按商品名称查询")
    @PostMapping("/retrieveByItemName")
    public RestObject<List<ItemDTO>> retrieveItemByItemName(@RequestBody Item item) {
        return iItemService.retrieveByItemName(item.getItemName(),item.getUserId());
    }
}

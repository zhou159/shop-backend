package com.zhou.shop.controller;

import com.zhou.shop.dto.ItemDto;
import com.zhou.shop.entity.Flag;
import com.zhou.shop.entity.Item;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IFlagService;
import com.zhou.shop.service.IItemService;
import com.zhou.shop.vo.ItemVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    public ItemController(IItemService iItemService,IFlagService iFlagService) {
        this.iItemService = iItemService;
        this.iFlagService = iFlagService;
    }

    @ApiOperation("新建商品")
    @PostMapping("/createItem")
    public RestObject<String> createItem(@RequestBody ItemVo itemVo) {
        String flagName = itemVo.getFlagName();
        Flag flag = iFlagService.retrieveByFlagName(flagName);
        String flagId;
        if (flag==null){
            Flag flag1 = new Flag();
            flag1.setFlagName(flagName);
            boolean save = iFlagService.save(flag1);
            if(!save){
                return RestResponse.makeErrRsp("新增标签时出现异常！");
            }
            Flag flag2 = iFlagService.retrieveByFlagName(flagName);
            flagId = flag2.getFlagId();
        }else {
            Flag flag1 = iFlagService.retrieveByFlagName(flagName);
            flagId = flag1.getFlagId();
        }
        Item item = new Item();
        BeanUtils.copyProperties(itemVo,item);
        item.setFlagId(flagId);
        item.setItemCreateTime(LocalDateTime.now());
        boolean save = iItemService.save(item);
        if (save) {
            return RestResponse.makeOkRsp("新增成功！");
        } else {
            return RestResponse.makeErrRsp("新增失败！");
        }
    }

    @ApiOperation("按商品id查询")
    @GetMapping("/retrieveByItemId/{itemId}")
    public RestObject<Item> retrieveByItemId(@PathVariable String itemId) {
        Item item = iItemService.getById(itemId);
        return RestResponse.makeOkRsp(item);
    }

    @ApiOperation("查询全部商品")
    @GetMapping("/retrieveAllItem")
    public RestObject<List<ItemDto>> retrieveAllItem() {
        List<ItemDto> list = iItemService.retrieveAllItem();
        return RestResponse.makeOkRsp(list);
    }

    @ApiOperation("按商品id更新")
    @PostMapping("/updateItemByItemId/{itemId}")
    public RestObject<String> updateItemByItemId(@PathVariable String itemId, @RequestBody ItemVo itemVo) {
        String flagName = itemVo.getFlagName();
        Flag flag = iFlagService.retrieveByFlagName(flagName);
        String flagId;
        if (flag==null){
            Flag flag1 = new Flag();
            flag1.setFlagName(flagName);
            boolean save = iFlagService.save(flag1);
            if(!save){
                return RestResponse.makeErrRsp("新增标签时出现异常！");
            }
            Flag flag2 = iFlagService.retrieveByFlagName(flagName);
            flagId = flag2.getFlagId();
        }else {
            Flag flag1 = iFlagService.retrieveByFlagName(flagName);
            flagId = flag1.getFlagId();
        }
        Item item = new Item();
        BeanUtils.copyProperties(itemVo,item);
        item.setFlagId(flagId);
        item.setItemId(itemId);
        item.setItemUpdateTime(LocalDateTime.now());
        boolean b = iItemService.updateById(item);
        if (b) {
            return RestResponse.makeOkRsp("修改成功！");
        } else {
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @ApiOperation("按商品id删除")
    @PostMapping("/deleteByItemId/{itemId}")
    public RestObject<String> deleteItemById(@PathVariable String itemId) {
        boolean b = iItemService.removeById(itemId);
        if (b) {
            return RestResponse.makeOkRsp("删除成功！");
        } else {
            return RestResponse.makeErrRsp("删除失败！");
        }
    }

    @ApiOperation("按商品名称查询")
    @PostMapping("/retrieveByItemName")
    public RestObject<List<ItemDto>> retrieveItemByItemName(@RequestBody Item item) {
        List<ItemDto> list = iItemService.retrieveByItemName(item.getItemName());
        return RestResponse.makeOkRsp(list);
    }
}

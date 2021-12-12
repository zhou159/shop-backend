package com.zhou.shop.controller;

import com.zhou.shop.dto.ItemDto;
import com.zhou.shop.entity.Flag;
import com.zhou.shop.entity.Item;
import com.zhou.shop.enums.LogStatus;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IFlagService;
import com.zhou.shop.service.IItemService;
import com.zhou.shop.util.LogUtil;
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
    final LogUtil logUtil;

    public ItemController(IItemService iItemService, IFlagService iFlagService, LogUtil logUtil) {
        this.iItemService = iItemService;
        this.iFlagService = iFlagService;
        this.logUtil = logUtil;
    }

    @ApiOperation("新建商品")
    @PostMapping("/createItem")
    public RestObject<String> createItem(@RequestBody ItemVo itemVo) {
        String flagName = itemVo.getFlagName();
        Flag flag = iFlagService.retrieveByFlagName(flagName);
        String flagId;
        if (flag == null) {
            Flag flag1 = new Flag();
            flag1.setFlagName(flagName);
            boolean save = iFlagService.save(flag1);
            if (!save) {
                logUtil.log("新增标签出现异常", LogStatus.ERROR.info);
                return RestResponse.makeErrRsp("新增标签时出现异常！");
            }
            Flag flag2 = iFlagService.retrieveByFlagName(flagName);
            flagId = flag2.getFlagId();
        } else {
            Flag flag1 = iFlagService.retrieveByFlagName(flagName);
            flagId = flag1.getFlagId();
        }
        Item item = new Item();
        BeanUtils.copyProperties(itemVo, item);
        item.setFlagId(flagId);
        item.setItemCreateTime(LocalDateTime.now());
        boolean save = iItemService.save(item);
        if (save) {
            logUtil.log("新增商品成功", LogStatus.INFO.info);
            return RestResponse.makeOkRsp("新增成功！");
        }
        logUtil.log("新增商品失败", LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("新增失败！");
    }

    @ApiOperation("按商品id查询")
    @GetMapping("/retrieveByItemId/{itemId}")
    public RestObject<Item> retrieveByItemId(@PathVariable String itemId) {
        Item item = iItemService.getById(itemId);
//        logUtil.log("查询了商品信息，商品ID：" + itemId, LogStatus.INFO.info);
        return RestResponse.makeOkRsp(item);
    }

    @ApiOperation("查询全部商品")
    @GetMapping("/retrieveAllItem")
    public RestObject<List<ItemDto>> retrieveAllItem() {
        List<ItemDto> list = iItemService.retrieveAllItem();
//        logUtil.log("查询了全部商品信息", LogStatus.INFO.info);
        return RestResponse.makeOkRsp(list);
    }

    @ApiOperation("按商品id更新")
    @PostMapping("/updateItemByItemId/{itemId}")
    public RestObject<String> updateItemByItemId(@PathVariable String itemId, @RequestBody ItemVo itemVo) {
        String flagName = itemVo.getFlagName();
        Flag flag = iFlagService.retrieveByFlagName(flagName);
        String flagId;
        if (flag == null) {
            Flag flag1 = new Flag();
            flag1.setFlagName(flagName);
            boolean save = iFlagService.save(flag1);
            if (!save) {
                logUtil.log("新增标签出现异常", LogStatus.ERROR.info);
                return RestResponse.makeErrRsp("新增标签时出现异常！");
            }
            Flag flag2 = iFlagService.retrieveByFlagName(flagName);
            flagId = flag2.getFlagId();
        } else {
            Flag flag1 = iFlagService.retrieveByFlagName(flagName);
            flagId = flag1.getFlagId();
        }
        Item item = new Item();
        BeanUtils.copyProperties(itemVo, item);
        item.setFlagId(flagId);
        item.setItemId(itemId);
        item.setItemUpdateTime(LocalDateTime.now());
        boolean b = iItemService.updateById(item);
        if (b) {
            logUtil.log("成功修改了商品信息，商品ID：" + itemId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("修改成功！");
        }
        logUtil.log("修改商品信息时失败，商品ID：" + itemId, LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("修改失败！");
    }

    @ApiOperation("按商品id删除")
    @PostMapping("/deleteByItemId/{itemId}")
    public RestObject<String> deleteItemById(@PathVariable String itemId) {
        boolean b = iItemService.removeById(itemId);
        if (b) {
            logUtil.log("成功删除了商品信息，商品ID：" + itemId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("删除成功！");
        }
        logUtil.log("删除商品信息时失败，商品ID：" + itemId, LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("删除失败！");
    }

    @ApiOperation("按商品名称查询")
    @PostMapping("/retrieveByItemName")
    public RestObject<List<ItemDto>> retrieveItemByItemName(@RequestBody Item item) {
        List<ItemDto> list = iItemService.retrieveByItemName(item.getItemName());
//        logUtil.log("按名查询了商品信息，商品名：" + item.getItemName(), LogStatus.INFO.info);
        return RestResponse.makeOkRsp(list);
    }
}

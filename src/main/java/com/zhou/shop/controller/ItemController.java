package com.zhou.shop.controller;

import com.zhou.shop.entity.Item;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;;
import com.zhou.shop.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
@RequestMapping("/item")
public class ItemController {

    @Autowired
    IItemService iItemService;

    @PostMapping("/createItem")
    public RestObject<String> createItem(@RequestBody Item item){
        item.setCreateTime(LocalDateTime.now());
        boolean save = iItemService.save(item);
        if (save){
            return RestResponse.makeOKRsp("新增成功！");
        }else {
            return RestResponse.makeErrRsp("新增成功！");
        }
    }

    @GetMapping("/retrieveByItemId/{itemId}")
    public RestObject<Item> retrieveByItemId(@PathVariable int itemId){
        Item item = iItemService.getById(itemId);
        return RestResponse.makeOKRsp(item);
    }

    @GetMapping("/retrieveAllItem")
    public RestObject<List<Item>> retrieveAllItem (){
        List<Item> list = iItemService.list();
        return RestResponse.makeOKRsp(list);
    }

    @PostMapping("/updateItemByItemId/{itemId}")
    public RestObject<String> updateItemByItemId(@PathVariable int itemId,@RequestBody Item item){
        item.setId(itemId);
        item.setUpdateTime(LocalDateTime.now());
        boolean b = iItemService.updateById(item);
        if (b){
            return RestResponse.makeOKRsp("修改成功！");
        }else {
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @PostMapping("/deleteByItemId/{itemId}")
    public RestObject<String> deleteItemById(@PathVariable int itemId){
        boolean b = iItemService.removeById(itemId);
        if (b){
            return RestResponse.makeOKRsp("删除成功！");
        }else {
            return RestResponse.makeErrRsp("删除失败！");
        }
    }
}
package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.zhou.shop.dto.ItemDto;
import com.zhou.shop.entity.Item;
import com.zhou.shop.mapper.ItemMapper;
import com.zhou.shop.service.IItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

    @Autowired
    ItemMapper itemMapper;

    @Override
    public List<ItemDto> retrieveAllItem() {
        return itemMapper.retrieveAllItem();
    }

    @Override
    public List<ItemDto> retrieveByItemName(String itemName) {
        return itemMapper.retrieveByItemName(itemName);
    }
}

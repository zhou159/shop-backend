package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.dto.ItemDto;
import com.zhou.shop.entity.Item;
import com.zhou.shop.mapper.ItemMapper;
import com.zhou.shop.service.IItemService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

    final ItemMapper itemMapper;

    public ItemServiceImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public boolean save(Item entity) {
        return false;
    }

    @Override
    public boolean removeById(Item entity) {
        return super.removeById(entity);
    }

    @Override
    public boolean updateById(Item entity) {
        return false;
    }

    @Override
    public List<Item> list(Wrapper<Item> queryWrapper){
        return super.list(queryWrapper);
    }

    @Override
    public Item getById(Serializable id){
        return super.getById(id);
    }

    @Override
    public List<ItemDto> retrieveAllItem() {
        return itemMapper.retrieveAllItem();
    }

    @Override
    public List<ItemDto> retrieveByItemName(String itemName) {
        return itemMapper.retrieveByItemName(itemName);
    }
}

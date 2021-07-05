package com.zhou.shop;

import com.zhou.shop.entity.Item;
import com.zhou.shop.entity.User;
import com.zhou.shop.mapper.ItemMapper;
import com.zhou.shop.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ShopApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ItemMapper itemMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void contextLoads2() {
        Item item = new Item();
        item.setIName("海飞丝洗发水（小）");
        item.setPrice(BigDecimal.valueOf(20));
        itemMapper.insert(item);
    }

}

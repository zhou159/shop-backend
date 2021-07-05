package com.zhou.shop;

import com.zhou.shop.entity.User;
import com.zhou.shop.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Tests {
    @Autowired
    UserMapper userMapper;


    @Test
    public void selectAll(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}

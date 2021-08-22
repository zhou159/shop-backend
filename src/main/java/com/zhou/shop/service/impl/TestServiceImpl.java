package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.Test;
import com.zhou.shop.mapper.TestMapper;
import com.zhou.shop.service.ITestService;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper,Test> implements ITestService{
}

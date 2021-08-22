package com.zhou.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.Test;

/**
 * @author Administrator
 */
public interface ITestService extends IService<Test> {
    /**
     * 新增单位
     * @param entity 单位对象
     * @return 布尔值
     */
    @Override
    boolean save(Test entity);
}

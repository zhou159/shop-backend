package com.zhou.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.Unit;

import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-07-20
 */
public interface IUnitService extends IService<Unit> {
    /**
     * 按单位名查询单位
     *
     * @param unitName 单位名
     * @return 单位对象
     */
    List<Unit> retrieveByUnitName(String unitName);
}

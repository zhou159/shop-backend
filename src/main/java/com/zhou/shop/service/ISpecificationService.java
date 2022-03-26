package com.zhou.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.Specification;

import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-07-20
 */
public interface ISpecificationService extends IService<Specification> {
    /**
     * 按规格名查询规格
     *
     * @param specificationName 规格名
     * @return 数组，规格对象
     */
    List<Specification> retrieveBySpecificationName(String specificationName);
}

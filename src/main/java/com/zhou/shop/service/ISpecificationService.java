package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.Shop;
import com.zhou.shop.entity.Specification;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 周雄
 * @since 2021-07-20
 */
public interface ISpecificationService extends IService<Specification> {

    @Override
    boolean save(Specification entity);

    @Override
    boolean removeById(Serializable id);

    @Override
    boolean updateById(Specification entity);

    @Override
    Specification getById(Serializable id);

    @Override
    List<Specification> list(Wrapper<Specification> queryWrapper);

    List<Specification> retrieveBySpecificationName(String specificationName);
}

package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.Specification;

import java.io.Serializable;
import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-07-20
 */
public interface ISpecificationService extends IService<Specification> {

    /**
     * 新增规格
     *
     * @param entity 规格对象
     * @return 布尔值
     */
    @Override
    boolean save(Specification entity);

    /**
     * 按id删除规格
     *
     * @param id 规格id
     * @return 布尔值
     */
    @Override
    boolean removeById(Serializable id);

    /**
     * 按id修改规格信息
     *
     * @param entity 规格对象
     * @return 布尔值
     */
    @Override
    boolean updateById(Specification entity);

    /**
     * 按id查询规格
     *
     * @param id 规格id
     * @return 规格对象
     */
    @Override
    Specification getById(Serializable id);

    /**
     * 查询全部规格
     *
     * @param queryWrapper 查询构造条件
     * @return 数组，全部规格
     */
    @Override
    List<Specification> list(Wrapper<Specification> queryWrapper);

    /**
     * 按规格名查询规格
     *
     * @param specificationName 规格名
     * @return 数组，规格对象
     */
    List<Specification> retrieveBySpecificationName(String specificationName);
}

package com.zhou.shop.apiServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.entity.Specification;
import com.zhou.shop.common.RestObject;

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
    RestObject<List<Specification>> retrieveBySpecificationName(String specificationName);

    /**
     * 新增
     *
     * @param specification
     */
    RestObject<String> createSpecification(Specification specification);

    /**
     * 根据id查询
     *
     * @param specificationId id
     * @return
     */
    RestObject<Specification> retrieveBySpecificationId(String specificationId);

    /**
     * 查询全部
     *
     * @return
     */
    RestObject<List<Specification>> retrieveAllSpecification();

    /**
     * 根据id修改
     *
     * @param specificationId id
     * @param specification 对象
     * @return
     */
    RestObject<String> updateSpecificationBySpecificationId(
            String specificationId, Specification specification);

    /**
     * 根据id删除
     *
     * @param specificationId id
     * @return
     */
    RestObject<String> deleteSpecificationById(String specificationId);
}

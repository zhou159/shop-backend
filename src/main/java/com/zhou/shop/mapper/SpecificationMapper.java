package com.zhou.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.entity.Shop;
import com.zhou.shop.entity.Specification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 周雄
 * @since 2021-07-20
 */

@Mapper
public interface SpecificationMapper extends BaseMapper<Specification> {
    List<Specification> retrieveBySpecificationName(@Param("specificationName")String specificationName);
}

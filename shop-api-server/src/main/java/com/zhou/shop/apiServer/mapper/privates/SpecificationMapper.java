package com.zhou.shop.apiServer.mapper.privates;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.api.entity.privates.Specification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author 周雄
 * @since 2021-07-20
 */
@Mapper
public interface SpecificationMapper extends BaseMapper<Specification> {
    List<Specification> retrieveBySpecificationName(
            @Param("specificationName") String specificationName);
}

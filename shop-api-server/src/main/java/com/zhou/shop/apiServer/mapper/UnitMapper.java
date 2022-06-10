package com.zhou.shop.apiServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.api.entity.privates.Unit;
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
public interface UnitMapper extends BaseMapper<Unit> {
    List<Unit> retrieveByUnitName(@Param("unitName") String unitName);
}

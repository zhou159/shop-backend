package com.zhou.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.entity.SitcomNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/** @author Administrator */
@Mapper
public interface SitcomNumberMapper extends BaseMapper<SitcomNumber> {
    /**
     * 根据连续剧id获取集数信息
     *
     * @param sitcomId 连续剧id
     * @return 集数信息数组
     */
    List<SitcomNumber> retrieveBySitcomId(@Param("sitcomId") String sitcomId);

    /**
     * 根据集名模糊查询
     *
     * @param sitcomNumberName 集名
     * @return 集数组
     */
    List<SitcomNumber> retrieveBySitcomNumberName(
            @Param("sitcomNumberName") String sitcomNumberName);
}

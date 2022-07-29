package com.zhou.shop.apiServer.mapper.privates;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.api.dto.SitcomDTO;
import com.zhou.shop.api.entity.privates.Sitcom;
import com.zhou.shop.apiServer.provider.SitcomProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/** @author Administrator */
@Mapper
public interface SitcomMapper extends BaseMapper<Sitcom> {
    @SelectProvider(type = SitcomProvider.class, method = "queryAllSitcom")
    List<SitcomDTO> queryAllSitcom(String userId);
}

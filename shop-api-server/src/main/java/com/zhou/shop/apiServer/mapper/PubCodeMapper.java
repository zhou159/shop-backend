package com.zhou.shop.apiServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.api.entity.PubCode;
import com.zhou.shop.apiServer.provider.PubCodeProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author 周雄
 * @date 2022/5/17 18:23
 * @description
 */
@Mapper
public interface PubCodeMapper extends BaseMapper<PubCode> {
    /**
     * 根据码表类别查询
     * @param pubCodeType 码表类别
     * @return 码表集合
     */
    @SelectProvider(type = PubCodeProvider.class, method = "queryPubCode")
    List<PubCode> queryByPubCode(String pubCodeType);
}

package com.zhou.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.dto.SitcomNumberDto;
import com.zhou.shop.entity.SitcomNumber;

import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-08-21
 */
public interface ISitcomNumberService extends IService<SitcomNumber> {
    /**
     * 根据连续剧id获取集数信息
     *
     * @param sitcomId 连续剧id
     * @return 集数信息数组
     */
    List<SitcomNumber> retrieveBySitcomId(String sitcomId);

    /**
     * 按集名查询集
     * @param sitcomId 连续剧ID
     * @param sitcomNumberName 集名
     * @return 集对象
     */
    List<SitcomNumber> retrieveBySitcomNumberName(String sitcomNumberName,String sitcomId);

    /**
     * 根据连续剧id删除所有剧集
     * @param sitcomId 连续剧id
     * @return 整数
     */
    int deleteBySitcomId(String sitcomId);

    /**
     * 查询集的数量
     * @param sitcomId
     * @return 集数
     */
    SitcomNumberDto readSitcomNumberCnt(String sitcomId);
}

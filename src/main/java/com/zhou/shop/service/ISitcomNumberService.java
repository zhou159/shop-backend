package com.zhou.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.entity.SitcomNumber;
import com.zhou.shop.result.RestObject;
import org.springframework.web.bind.annotation.PathVariable;

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
    RestObject<List<SitcomNumber>> retrieveBySitcomId(String sitcomId);

    /**
     * 按集名查询集
     *
     * @param sitcomId 连续剧id
     * @param sitcomNumberName 集名
     * @return 集对象
     */
    RestObject<List<SitcomNumber>> retrieveBySitcomNumberName(
            String sitcomNumberName, String sitcomId);

    /**
     * 新增
     *
     * @param sitcomNumber 对象
     * @return
     */
    RestObject<String> createSitcomNumber(SitcomNumber sitcomNumber);

    /**
     * 快速新增
     *
     * @param sitcomNumber 对象
     * @return
     */
    RestObject<String> createSitcomNumberFast(SitcomNumber sitcomNumber);

    /**
     * 按剧集id查询
     *
     * @param sitcomNumberId 剧集id
     * @return
     */
    RestObject<SitcomNumber> retrieveBySitcomNumberId(@PathVariable String sitcomNumberId);

    /**
     * 查询全部
     *
     * @return
     */
    RestObject<List<SitcomNumber>> retrieveAllSitcomNumber();

    /**
     * 按id修改
     *
     * @param sitcomNumberId 剧集id
     * @param sitcomNumber 对象
     * @return
     */
    RestObject<String> updateSitcomNumberBySitcomNumberId(
            String sitcomNumberId, SitcomNumber sitcomNumber);

    /**
     * 按id删除
     *
     * @param sitcomNumberId
     * @return
     */
    RestObject<String> deleteSitcomNumberById(String sitcomNumberId);
}

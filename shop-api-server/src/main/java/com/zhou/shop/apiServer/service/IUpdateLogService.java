package com.zhou.shop.apiServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.entity.UpdateLog;
import com.zhou.shop.common.RestObject;

import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-07-24
 */
public interface IUpdateLogService extends IService<UpdateLog> {

    /**
     * 新增
     *
     * @param updateLog
     * @return
     */
    RestObject<String> createUpdateLog(UpdateLog updateLog);

    /**
     * 根据id查询
     *
     * @param updateLogId id
     * @return updateLog对象
     */
    RestObject<UpdateLog> retrieveByUpdateId(Integer updateLogId);

    /**
     * 查询全部
     *
     * @return
     */
    RestObject<List<UpdateLog>> retrieveAllUpdateLog();

    /**
     * 根据id修改
     *
     * @param updateLogId id
     * @param updateLog
     * @return
     */
    RestObject<String> updateUpdateByUpdateId(Integer updateLogId, UpdateLog updateLog);

    /**
     * 根据id删除
     *
     * @param updateLogId id
     * @return
     */
    RestObject<String> deleteUpdateById(Integer updateLogId);
}

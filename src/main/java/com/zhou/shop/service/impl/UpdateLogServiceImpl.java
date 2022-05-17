package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.UpdateLog;
import com.zhou.shop.exception.ShopException;
import com.zhou.shop.mapper.UpdateLogMapper;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IUpdateLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-07-24
 */
@Service
public class UpdateLogServiceImpl extends ServiceImpl<UpdateLogMapper, UpdateLog>
        implements IUpdateLogService {
    private final UpdateLogMapper updateLogMapper;

    private final Logger log = LoggerFactory.getLogger(UpdateLogServiceImpl.class);

    public UpdateLogServiceImpl(UpdateLogMapper updateLogMapper) {
        this.updateLogMapper = updateLogMapper;
    }

    @Override
    public RestObject<String> createUpdateLog(UpdateLog updateLog) {
        LocalDate updateLogCreateTime = updateLog.getUpdateLogCreateTime();
        if (updateLogCreateTime == null) {
            updateLog.setUpdateLogCreateTime(LocalDate.now());
        }
        int insert = updateLogMapper.insert(updateLog);
        if (insert < 1) {
            log.warn("新增更新日志失败！");
            throw new ShopException("新增失败！");
        }
        log.info("新增更新日志成功！");
        return RestResponse.makeOkRsp("新增成功!");
    }

    @Override
    public RestObject<UpdateLog> retrieveByUpdateId(Integer updateLogId) {
        return RestResponse.makeOkRsp(updateLogMapper.selectById(updateLogId));
    }

    @Override
    public RestObject<List<UpdateLog>> retrieveAllUpdateLog() {
        /*写null可以全表查*/
        return RestResponse.makeOkRsp(updateLogMapper.selectList(null));
    }

    @Override
    public RestObject<String> updateUpdateByUpdateId(Integer updateLogId, UpdateLog updateLog) {
        updateLog.setUpdateLogId(updateLogId);
        int i = updateLogMapper.updateById(updateLog);
        if (i < 1) {
            log.warn("修改更新日志失败！更新日志id:" + updateLogId);
            throw new ShopException("修改失败！");
        }
        log.info("修改更新日志成功！更新日志id:" + updateLogId);
        return RestResponse.makeOkRsp("修改成功！");
    }

    @Override
    public RestObject<String> deleteUpdateById(Integer updateLogId) {
        int i = updateLogMapper.deleteById(updateLogId);
        if (i < 1) {
            log.warn("删除更新日志失败！更新日志id:" + updateLogId);
            throw new ShopException("删除失败！");
        }
        log.info("删除更新日志成功！更新日志id:" + updateLogId);
        return RestResponse.makeOkRsp("删除成功！");
    }
}

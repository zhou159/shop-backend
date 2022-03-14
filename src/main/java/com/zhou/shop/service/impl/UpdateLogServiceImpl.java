package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.UpdateLog;
import com.zhou.shop.mapper.UpdateLogMapper;
import com.zhou.shop.service.IUpdateLogService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
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
    @Override
    public boolean save(UpdateLog entity) {
        return false;
    }

    @Override
    public boolean removeById(UpdateLog entity) {
        return super.removeById(entity);
    }

    @Override
    public boolean updateById(UpdateLog entity) {
        return false;
    }

    @Override
    public List<UpdateLog> list(Wrapper<UpdateLog> queryWrapper){
        return super.list(queryWrapper);
    }

    @Override
    public UpdateLog getById(Serializable id){
        return super.getById(id);
    }
}

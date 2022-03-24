package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.Log;
import com.zhou.shop.mapper.LogMapper;
import com.zhou.shop.service.ILogService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-09-04
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {
    @Override
    public boolean save(Log entity) {
        return super.save(entity);
    }

    @Override
    public boolean removeById(Log entity) {
        return super.removeById(entity);
    }

    @Override
    public boolean updateById(Log entity) {
        return super.updateById(entity);
    }

    @Override
    public List<Log> list(Wrapper<Log> queryWrapper){
        return super.list(queryWrapper);
    }

    @Override
    public Log getById(Serializable id){
        return super.getById(id);
    }
}

package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.dto.SitcomNumberDto;
import com.zhou.shop.entity.SitcomNumber;
import com.zhou.shop.mapper.SitcomNumberMapper;
import com.zhou.shop.service.ISitcomNumberService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-08-21
 */
@Service
public class SitcomNumberServiceImpl extends ServiceImpl<SitcomNumberMapper, SitcomNumber>
        implements ISitcomNumberService {
    final SitcomNumberMapper sitcomNumberMapper;

    public SitcomNumberServiceImpl(SitcomNumberMapper sitcomNumberMapper) {
        this.sitcomNumberMapper = sitcomNumberMapper;
    }

    @Override
    public boolean save(SitcomNumber entity) {
        return super.save(entity);
    }

    @Override
    public boolean removeById(SitcomNumber entity) {
        return super.removeById(entity);
    }

    @Override
    public boolean updateById(SitcomNumber entity) {
        return super.updateById(entity);
    }

    @Override
    public List<SitcomNumber> list(Wrapper<SitcomNumber> queryWrapper){
        return super.list(queryWrapper);
    }

    @Override
    public SitcomNumber getById(Serializable id){
        return super.getById(id);
    }

    @Override
    public List<SitcomNumber> retrieveBySitcomId(String sitcomId) {
        return sitcomNumberMapper.retrieveBySitcomId(sitcomId);
    }

    @Override
    public List<SitcomNumber> retrieveBySitcomNumberName(String sitcomNumberName,String sitcomId) {
        return sitcomNumberMapper.retrieveBySitcomNumberName(sitcomNumberName,sitcomId);
    }

    @Override
    public int deleteBySitcomId(String sitcomId) {
        return sitcomNumberMapper.deleteBySitcomId(sitcomId);
    }

    @Override
    public SitcomNumberDto readMaxSitcomNumberNumber(String sitcomId) {
        return sitcomNumberMapper.readMaxSitcomNumberNumber(sitcomId);
    }

    @Override
    public SitcomNumberDto readSitcomNumberCnt(String sitcomId) {
        return sitcomNumberMapper.readSitcomNumberCnt(sitcomId);
    }
}

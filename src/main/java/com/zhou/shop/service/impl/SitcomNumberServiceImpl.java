package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.dto.SitcomNumberDto;
import com.zhou.shop.entity.SitcomNumber;
import com.zhou.shop.mapper.SitcomNumberMapper;
import com.zhou.shop.service.ISitcomNumberService;
import org.springframework.stereotype.Service;

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
    public SitcomNumberDto readSitcomNumberCnt(String sitcomId) {
        return sitcomNumberMapper.readSitcomNumberCnt(sitcomId);
    }
}

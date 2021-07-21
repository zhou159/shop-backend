package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.Shop;
import com.zhou.shop.entity.Specification;
import com.zhou.shop.mapper.SpecificationMapper;
import com.zhou.shop.service.ISpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 周雄
 * @since 2021-07-20
 */
@Service
public class SpecificationServiceImpl extends ServiceImpl<SpecificationMapper, Specification> implements ISpecificationService {

    @Autowired
    SpecificationMapper specificationMapper;

    @Override
    public List<Specification> retrieveBySpecificationName(String specificationName) {
        return specificationMapper.retrieveBySpecificationName(specificationName);
    }
}

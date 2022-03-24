package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.Specification;
import com.zhou.shop.mapper.SpecificationMapper;
import com.zhou.shop.service.ISpecificationService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-07-20
 */
@Service
public class SpecificationServiceImpl extends ServiceImpl<SpecificationMapper, Specification>
        implements ISpecificationService {

    final SpecificationMapper specificationMapper;

    public SpecificationServiceImpl(SpecificationMapper specificationMapper) {
        this.specificationMapper = specificationMapper;
    }

    @Override
    public boolean save(Specification entity) {
        return super.save(entity);
    }

    @Override
    public boolean removeById(Specification entity) {
        return super.removeById(entity);
    }

    @Override
    public boolean updateById(Specification entity) {
        return super.updateById(entity);
    }

    @Override
    public List<Specification> list(Wrapper<Specification> queryWrapper){
        return super.list(queryWrapper);
    }

    @Override
    public Specification getById(Serializable id){
        return super.getById(id);
    }

    @Override
    public List<Specification> retrieveBySpecificationName(String specificationName) {
        return specificationMapper.retrieveBySpecificationName(specificationName);
    }
}

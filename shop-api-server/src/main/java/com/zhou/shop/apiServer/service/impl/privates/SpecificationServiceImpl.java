package com.zhou.shop.apiServer.service.impl.privates;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.privates.Specification;
import com.zhou.shop.apiServer.mapper.privates.SpecificationMapper;
import com.zhou.shop.apiServer.service.privates.ISpecificationService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.common.exception.ShopException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

    private final SpecificationMapper specificationMapper;

    private final Logger log = LoggerFactory.getLogger(SpecificationServiceImpl.class);

    public SpecificationServiceImpl(SpecificationMapper specificationMapper) {
        this.specificationMapper = specificationMapper;
    }

    @Override
    public RestObject<List<Specification>> retrieveBySpecificationName(String specificationName) {
        return RestResponse.makeOkRsp(
                specificationMapper.retrieveBySpecificationName(specificationName));
    }

    @Override
    public RestObject<String> createSpecification(Specification specification) {
        int insert = specificationMapper.insert(specification);
        if (insert < 1) {
            log.warn("新增规格失败！");
            throw new ShopException("新增失败！");
        }
        log.info("新增规格成功！");
        return RestResponse.makeOkRsp("新增成功!");
    }

    @Override
    public RestObject<Specification> retrieveBySpecificationId(String specificationId) {
        return RestResponse.makeOkRsp(specificationMapper.selectById(specificationId));
    }

    @Override
    public RestObject<List<Specification>> retrieveAllSpecification() {
        return RestResponse.makeOkRsp(specificationMapper.selectList(null));
    }

    @Override
    public RestObject<String> updateSpecificationBySpecificationId(
            String specificationId, Specification specification) {
        specification.setSpecificationId(specificationId);
        int i = specificationMapper.updateById(specification);
        if (i < 1) {
            log.warn("修改规格失败");
            throw new ShopException("修改失败！");
        }
        log.info("修改规格成功！规格id:" + specificationId);
        return RestResponse.makeOkRsp("修改成功！");
    }

    @Override
    public RestObject<String> deleteSpecificationById(String specificationId) {
        int i = specificationMapper.deleteById(specificationId);
        if (i < 1) {
            log.warn("删除规格失败！规格id:" + specificationId);
            throw new ShopException("删除失败！");
        }
        log.info("删除规格成功！规格id:" + specificationId);
        return i > 0 ? RestResponse.makeOkRsp("删除成功！") : RestResponse.makeOkRsp("删除失败！");
    }
}

package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.dto.IssueModuleDto;
import com.zhou.shop.entity.Issue;
import com.zhou.shop.mapper.IssueMapper;
import com.zhou.shop.service.IIssueService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Service
public class IssueServiceImpl extends ServiceImpl<IssueMapper, Issue> implements IIssueService {

    final IssueMapper issueMapper;

    public IssueServiceImpl(IssueMapper issueMapper) {
        this.issueMapper = issueMapper;
    }

    @Override
    public List<Issue> retrieveByIssueDescription(String issueDescription) {
        return issueMapper.retrieveByIssueDescription(issueDescription);
    }

    @Override
    public boolean save(Issue entity) {
        return false;
    }

    @Override
    public boolean removeById(Issue entity) {
        return super.removeById(entity);
    }

    @Override
    public boolean updateById(Issue entity) {
        return false;
    }

    @Override
    public List<Issue> list(Wrapper<Issue> queryWrapper){
        return super.list(queryWrapper);
    }

    @Override
    public Issue getById(Serializable id){
        return super.getById(id);
    }

    @Override
    public List<IssueModuleDto> getIssueModule() {
        return issueMapper.getIssueModule();
    }

    @Override
    public List<Issue> readEffectiveIssue() {
        return issueMapper.readEffectiveIssue();
    }

    @Override
    public int updateIssueStatus(String issueId, String issueStatus) {
        return issueMapper.updateIssueStatus(issueId,issueStatus);
    }
}

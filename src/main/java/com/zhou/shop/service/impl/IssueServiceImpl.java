package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.dto.IssueModuleDto;
import com.zhou.shop.entity.Issue;
import com.zhou.shop.exception.ShopException;
import com.zhou.shop.mapper.IssueMapper;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IIssueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Service
public class IssueServiceImpl extends ServiceImpl<IssueMapper, Issue> implements IIssueService {

    private final IssueMapper issueMapper;

    private final Logger log = LoggerFactory.getLogger(IssueServiceImpl.class);

    public IssueServiceImpl(IssueMapper issueMapper) {
        this.issueMapper = issueMapper;
    }

    @Override
    public RestObject<List<Issue>> retrieveByIssueDescription(String issueDescription) {
        return RestResponse.makeOkRsp(issueMapper.retrieveByIssueDescription(issueDescription));
    }

    @Override
    public RestObject<List<IssueModuleDto>> getIssueModule() {
        return RestResponse.makeOkRsp(issueMapper.getIssueModule());
    }

    @Override
    public RestObject<List<Issue>> readEffectiveIssue() {
        return RestResponse.makeOkRsp(issueMapper.readEffectiveIssue());
    }

    @Override
    public RestObject<String> updateIssueStatus(String issueId, String issueStatus) {
        Issue issue = new Issue();
        issue.setIssueStatus(issueStatus).setIssueSolveTime(LocalDateTime.now());
        int i = issueMapper.updateIssueStatus(issueId, issue);
        if (i < 1) {
            log.warn("修改问题状态失败！问题id:" + issueId);
            throw new ShopException("修改失败！");
        }
        log.info("修改问题状态成功！问题id:" + issueId);
        return RestResponse.makeOkRsp("修改成功！");
    }

    @Override
    public RestObject<String> createIssue(Issue issue) {
        issue.setIssueCreateTime(LocalDateTime.now());
        int insert = issueMapper.insert(issue);
        if (insert < 1) {
            log.warn("新增问题失败！");
            throw new ShopException("新增失败！");
        }
        log.info("新增问题成功！");
        return RestResponse.makeOkRsp("新增成功!");
    }

    @Override
    public RestObject<Issue> retrieveByIssueId(String issueId) {
        return RestResponse.makeOkRsp(issueMapper.selectById(issueId));
    }

    @Override
    public RestObject<List<Issue>> retrieveAllIssue() {
        return RestResponse.makeOkRsp(issueMapper.readEffectiveIssue());
    }

    @Override
    public RestObject<String> updateIssueByIssueId(String issueId, Issue issue) {
        issue.setIssueId(issueId);
        int i = issueMapper.updateById(issue);
        if (i < 1) {
            log.warn("修改问题失败！问题id:" + issueId);
            throw new ShopException("修改失败！");
        }
        log.info("修改问题成功！问题id:" + issueId);
        return RestResponse.makeOkRsp("修改成功！");
    }

    @Override
    public RestObject<String> deleteIssueById(String issueId) {
        int i = issueMapper.deleteById(issueId);
        if (i < 1) {
            log.warn("删除问题失败，问题id:" + issueId);
            throw new ShopException("删除失败！");
        }
        log.info("删除问题成功，问题id:" + issueId);
        return RestResponse.makeOkRsp("删除成功！");
    }
}

package com.zhou.shop.apiServer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.dto.IssueModuleDTO;
import com.zhou.shop.api.entity.Issue;
import com.zhou.shop.api.entity.PubCode;
import com.zhou.shop.apiServer.mapper.IssueMapper;
import com.zhou.shop.apiServer.mapper.PubCodeMapper;
import com.zhou.shop.apiServer.service.IIssueService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.common.exception.ShopException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private final PubCodeMapper pubCodeMapper;

    private final Logger log = LoggerFactory.getLogger(IssueServiceImpl.class);

    public IssueServiceImpl(IssueMapper issueMapper, PubCodeMapper pubCodeMapper) {
        this.issueMapper = issueMapper;
        this.pubCodeMapper = pubCodeMapper;
    }

    @Override
    public RestObject<List<Issue>> retrieveByIssueDescription(String issueDescription) {
        return RestResponse.makeOkRsp(
                issueMapper.selectList(
                        new LambdaQueryWrapper<Issue>()
                                .like(Issue::getIssueDescription, issueDescription)
                                .eq(Issue::getIssueStatus, "0")));
    }

    @Override
    public RestObject<List<IssueModuleDTO>> getIssueModule() {
        return RestResponse.makeOkRsp(issueMapper.getIssueModule());
    }

    @Override
    public RestObject<String> updateIssueStatus(String issueId, String issueStatus) {
        final int update =
                issueMapper.update(
                        null,
                        new LambdaUpdateWrapper<Issue>()
                                .set(Issue::getIssueStatus, issueStatus)
                                .set(Issue::getIssueSolveTime, LocalDateTime.now())
                                .eq(Issue::getIssueId, issueId));
        return update > 1 ? RestResponse.makeOkRsp("修改成功！") : RestResponse.makeErrRsp("修改失败！");
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
        ArrayList<Issue> issueArrayList = new ArrayList<>();
        for (Issue issue :
                issueMapper.selectList(
                        new LambdaQueryWrapper<Issue>().eq(Issue::getIssueStatus, "0"))) {
            issue.setIssueType(
                    pubCodeMapper
                            .selectOne(
                                    new LambdaQueryWrapper<PubCode>()
                                            .eq(PubCode::getPubcodeClassId, issue.getIssueType()))
                            .getPubcodeName());
            issue.setIssueModule(
                    pubCodeMapper
                            .selectOne(
                                    new LambdaQueryWrapper<PubCode>()
                                            .eq(PubCode::getPubcodeClassId, issue.getIssueModule()))
                            .getPubcodeName());
            issueArrayList.add(issue);
        }
        return RestResponse.makeOkRsp(issueArrayList);
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

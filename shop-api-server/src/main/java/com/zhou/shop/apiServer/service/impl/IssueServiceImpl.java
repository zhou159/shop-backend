package com.zhou.shop.apiServer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.dto.IssueDTO;
import com.zhou.shop.api.entity.Issue;
import com.zhou.shop.api.entity.PubCode;
import com.zhou.shop.api.vo.IssueAddVo;
import com.zhou.shop.apiServer.mapper.IssueMapper;
import com.zhou.shop.apiServer.mapper.PubCodeMapper;
import com.zhou.shop.apiServer.service.IIssueService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.common.exception.ShopException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
    public RestObject<String> updateIssueStatus(String issueId, String issueStatus) {
        final int update =
                issueMapper.update(
                        null,
                        new LambdaUpdateWrapper<Issue>()
                                .set(Issue::getIssueStatus, issueStatus)
                                .set(Issue::getIssueSolveTime, LocalDateTime.now())
                                .eq(Issue::getIssueId, issueId));
        return update > 0 ? RestResponse.makeOkRsp("修改成功！") : RestResponse.makeErrRsp("修改失败！");
    }

    @Override
    public RestObject<String> createIssue(IssueAddVo issue) {
        Issue issue1 = new Issue();
        BeanUtils.copyProperties(issue,issue1);
        issue1.setIssueCreateTime(LocalDateTime.now());
        int insert = issueMapper.insert(issue1);
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
    public RestObject<List<IssueDTO>> retrieveAllIssue() {
        final List<Issue> issues =
                issueMapper.selectList(
                        new LambdaQueryWrapper<Issue>().eq(Issue::getIssueStatus, "0"));
        return RestResponse.makeOkRsp(issueDeal(issues));
    }

    /**
     * 问题对象处理
     *
     * @param issues 问题集合
     * @return 处理后的问题集合
     */
    private List<IssueDTO> issueDeal(List<Issue> issues) {
        List<IssueDTO> issueArrayList = new ArrayList<>();
        for (Issue issue : issues) {
            final IssueDTO issueDTO = new IssueDTO();
            BeanUtils.copyProperties(issue, issueDTO);
            final PubCode typePubCode =
                    pubCodeMapper.selectOne(
                            new LambdaQueryWrapper<PubCode>()
                                    .eq(PubCode::getPubCodeId, issue.getIssueType()));
            issueDTO.setIssueTypeName(typePubCode.getPubCodeName());

            final PubCode modulePubCode =
                    pubCodeMapper.selectOne(
                            new LambdaQueryWrapper<PubCode>()
                                    .eq(PubCode::getPubCodeId, issue.getIssueModule()));
            issueDTO.setIssueModuleName(modulePubCode.getPubCodeName());

            issueArrayList.add(issueDTO);
        }

        return issueArrayList;
    }

    @Override
    public RestObject<String> updateIssueByIssueId(String userId, Issue issue) {
        final Issue issue1 =
                issueMapper.selectOne(
                        new LambdaQueryWrapper<Issue>().eq(Issue::getIssueId, issue.getIssueId()));
        if (!issue1.getIssueCreateBy().equals(userId)) {
            throw new ShopException("您不是问题创建者，无权修改！");
        }
        issue.setIssueUpdateTime(LocalDateTime.now());
        int i = issueMapper.updateById(issue);
        if (i < 1) {
            log.warn("修改问题失败！问题id:" + issue.getIssueId());
            throw new ShopException("修改失败！");
        }
        log.info("修改问题成功！问题id:" + issue.getIssueId());
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

    @Override
    public RestObject<List<IssueDTO>> retrieveByUserId(String userId) {
        final List<Issue> issues =
                issueMapper.selectList(
                        new LambdaQueryWrapper<Issue>().eq(Issue::getIssueCreateBy, userId));
        return RestResponse.makeOkRsp(issueDeal(issues));
    }

    @Override
    public RestObject<List<IssueDTO>> searchIssue(Issue issue) {
        return RestResponse.makeOkRsp(issueMapper.search(issue));
    }
}

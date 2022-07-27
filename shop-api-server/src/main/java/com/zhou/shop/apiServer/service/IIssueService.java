package com.zhou.shop.apiServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.dto.IssueDTO;
import com.zhou.shop.api.entity.Issue;
import com.zhou.shop.api.vo.IssueAddVo;
import com.zhou.shop.common.RestObject;

import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-06-24
 */
public interface IIssueService extends IService<Issue> {

    /**
     * 修改问题状态
     *
     * @param issueId 问题ID
     * @param issueStatus 问题状态
     * @return 布尔值
     */
    RestObject<String> updateIssueStatus(String issueId, String issueStatus);

    /**
     * 新增
     *
     * @param issue 对象
     * @return 信息
     */
    RestObject<String> createIssue(IssueAddVo issue);

    /**
     * 根据id查询
     *
     * @param issueId id
     * @return 信息
     */
    RestObject<Issue> retrieveByIssueId(String issueId);

    /**
     * 查询全部
     *
     * @return 信息
     */
    RestObject<List<IssueDTO>> retrieveAllIssue();

    /**
     * 根据id修改
     *
     * @param userId 修改问题的userId
     * @param issue 对象
     * @return 信息
     */
    RestObject<String> updateIssueByIssueId(String userId, Issue issue);

    /**
     * 根据id删除
     *
     * @param issueId id
     * @return 信息
     */
    RestObject<String> deleteIssueById(String issueId);

    /**
     * 根据创建人id查询
     *
     * @param userId 用户Id
     * @return 问题集合
     */
    RestObject<List<IssueDTO>> retrieveByUserId(String userId);

    /**
     * 按条件查询问题
     * @param issue 问题实体
     * @return 问题集合
     */
    RestObject<List<IssueDTO>> searchIssue(Issue issue);
}

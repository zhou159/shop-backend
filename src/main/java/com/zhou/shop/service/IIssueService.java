package com.zhou.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.dto.IssueModuleDto;
import com.zhou.shop.entity.Issue;
import com.zhou.shop.result.RestObject;

import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-06-24
 */
public interface IIssueService extends IService<Issue> {
    /**
     * 获取所有模块（数据表）
     *
     * @return 模块表数组
     */
    RestObject<List<IssueModuleDto>> getIssueModule();

    /**
     * 根据问题描述模糊查询
     *
     * @param issueDescription 问题描述
     * @return 问题数组
     */
    RestObject<List<Issue>> retrieveByIssueDescription(String issueDescription);

    /**
     * 查询未解决的问题
     *
     * @return 问题数组
     */
    RestObject<List<Issue>> readEffectiveIssue();

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
     * @return
     */
    RestObject<String> createIssue(Issue issue);

    /**
     * 根据id查询
     *
     * @param issueId id
     * @return
     */
    RestObject<Issue> retrieveByIssueId(String issueId);

    /**
     * 查询全部
     *
     * @return
     */
    RestObject<List<Issue>> retrieveAllIssue();

    /**
     * 根据id修改
     *
     * @param issueId id
     * @param issue 对象
     * @return
     */
    RestObject<String> updateIssueByIssueId(String issueId, Issue issue);

    /**
     * 根据id删除
     *
     * @param issueId id
     * @return
     */
    RestObject<String> deleteIssueById(String issueId);
}

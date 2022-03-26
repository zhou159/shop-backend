package com.zhou.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.dto.IssueModuleDto;
import com.zhou.shop.entity.Issue;

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
    List<IssueModuleDto> getIssueModule();

    /**
     * 根据问题描述模糊查询
     *
     * @param issueDescription 问题描述
     * @return 问题数组
     */
    List<Issue> retrieveByIssueDescription(String issueDescription);

    /**
     * 查询未解决的问题
     *
     * @return 问题数组
     */
    List<Issue> readEffectiveIssue();

    /**
     * 修改问题状态
     * @param issueId 问题ID
     * @param issueStatus 问题状态
     * @return 布尔值
     */
    int updateIssueStatus(String issueId, String issueStatus);
}

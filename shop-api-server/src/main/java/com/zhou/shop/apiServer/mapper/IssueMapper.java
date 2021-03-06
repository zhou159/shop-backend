package com.zhou.shop.apiServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.api.dto.IssueModuleDto;
import com.zhou.shop.api.entity.Issue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Mapper
public interface IssueMapper extends BaseMapper<Issue> {
    /**
     * 获取所有模块（数据表）
     * @return 模块表数组
     */
    List<IssueModuleDto> getIssueModule();

    /**
     * 根据问题描述模糊查询
     *
     * @param issueDescription 问题描述
     * @return 问题数组
     */
    List<Issue> retrieveByIssueDescription(@Param("issueDescription") String issueDescription);

    /**
     * 查询未解决的问题
     * @return 问题数组
     */
    List<Issue> readEffectiveIssue();

    /**
     * 修改问题状态
     *
     * @param issueId 问题ID
     * @param issue 问题对象
     * @return 布尔值
     */
    int updateIssueStatus(@Param("issueId") String issueId, @Param("issue") Issue issue);
}

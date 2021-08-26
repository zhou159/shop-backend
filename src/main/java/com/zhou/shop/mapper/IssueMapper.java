package com.zhou.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.dto.IssueModuleDto;
import com.zhou.shop.entity.Issue;
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
     * @param issueDescription 问题描述
     * @return 问题数组
     */
    List<Issue> retrieveByIssueDescription(@Param("issueDescription")String issueDescription);

}

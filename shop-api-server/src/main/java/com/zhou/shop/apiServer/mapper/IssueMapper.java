package com.zhou.shop.apiServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.api.dto.IssueDTO;
import com.zhou.shop.api.entity.Issue;
import com.zhou.shop.apiServer.provider.IssueProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

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
     * 条件查询问题
     * @param issue 问题实体
     * @return 集合
     */
    @SelectProvider(type = IssueProvider.class, method = "queryIssue")
    List<IssueDTO> search(Issue issue);
}

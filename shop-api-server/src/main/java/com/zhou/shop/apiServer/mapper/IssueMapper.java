package com.zhou.shop.apiServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.api.dto.IssueModuleDTO;
import com.zhou.shop.api.entity.Issue;
import org.apache.ibatis.annotations.Mapper;

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
    List<IssueModuleDTO> getIssueModule();
}

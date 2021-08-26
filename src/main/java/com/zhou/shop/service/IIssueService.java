package com.zhou.shop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.dto.IssueModuleDto;
import com.zhou.shop.entity.Issue;

import java.io.Serializable;
import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-06-24
 */
public interface IIssueService extends IService<Issue> {
    /**
     * 按id删除问题
     *
     * @param id 问题id
     * @return 问题对象
     */
    @Override
    boolean removeById(Serializable id);

    /**
     * 新增问题
     *
     * @param entity 问题对象
     * @return 问题对象
     */
    @Override
    boolean save(Issue entity);

    /**
     * 按id修改问题数据
     *
     * @param entity 问题对象
     * @return 问题对象
     */
    @Override
    boolean updateById(Issue entity);

    /**
     * 查询全部问题
     *
     * @param queryWrapper 查询构造条件
     * @return 数组，全部问题
     */
    @Override
    List<Issue> list(Wrapper<Issue> queryWrapper);

    /**
     * 按id查询问题
     *
     * @param id 问题id
     * @return 问题对象
     */
    @Override
    Issue getById(Serializable id);

    /**
     * 获取所有模块（数据表）
     *
     * @return 模块表数组
     */
    List<IssueModuleDto> getIssueModule();

    /**
     * 根据问题描述模糊查询
     * @param issueDescription 问题描述
     * @return 问题数组
     */
    List<Issue> retrieveByIssueDescription(String issueDescription);
}

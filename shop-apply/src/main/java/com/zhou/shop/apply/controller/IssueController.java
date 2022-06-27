package com.zhou.shop.apply.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.zhou.shop.api.dto.IssueModuleDTO;
import com.zhou.shop.api.entity.Issue;
import com.zhou.shop.apiServer.service.IIssueService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前端控制器
 *
 * @author 周雄
 * @since 2021-06-24
 */
@RestController
@RequestMapping("/issue")
@Api(tags = "问题")
public class IssueController {
    private final IIssueService iIssueService;

    public IssueController(IIssueService iIssueService) {
        this.iIssueService = iIssueService;
    }

    @SaCheckLogin
    @ApiOperation("新增问题")
    @PostMapping("/createIssue")
    public RestObject<String> createIssue(@RequestBody Issue issue) {
        return iIssueService.createIssue(issue);
    }

    @ApiOperation("按id查询问题")
    @GetMapping("/retrieveByIssueId/{issueId}")
    public RestObject<Issue> retrieveByIssueId(@PathVariable String issueId) {
        return iIssueService.retrieveByIssueId(issueId);
    }

    @ApiOperation("查询全部未解决的问题")
    @GetMapping("/retrieveAllIssue")
    public RestObject<List<Issue>> retrieveAllIssue() {
        return iIssueService.retrieveAllIssue();
    }

    @SaCheckLogin
    @ApiOperation("按id修改问题")
    @PostMapping("/updateIssueByIssueId/{issueId}")
    public RestObject<String> updateIssueByIssueId(@PathVariable String issueId, @RequestBody Issue issue) {
        return iIssueService.updateIssueByIssueId(issueId, issue);
    }

    @SaCheckRole("superAdmin")
    @ApiOperation("按id删除问题")
    @PostMapping("/deleteByIssueId/{issueId}")
    public RestObject<String> deleteIssueById(@PathVariable String issueId) {
        return iIssueService.deleteIssueById(issueId);
    }

    @ApiOperation("查询全部问题板块")
    @GetMapping("/issueModule")
    public RestObject<List<IssueModuleDTO>> getIssueModule() {
        return iIssueService.getIssueModule();
    }

    @ApiOperation("根据问题描述模糊查询")
    @PostMapping("/retrieveByIssueDescription")
    public RestObject<List<Issue>> retrieveByIssueDescription(@RequestBody Issue issue) {
        return iIssueService.retrieveByIssueDescription(issue.getIssueDescription());
    }

    @SaCheckLogin
    @ApiOperation("修改问题状态")
    @PostMapping("/updateIssueStatus/{issueId}")
    public RestObject<String> updateIssueStatus(@PathVariable String issueId, @RequestBody Issue issue) {
        return iIssueService.updateIssueStatus(issueId, issue.getIssueStatus());
    }
}

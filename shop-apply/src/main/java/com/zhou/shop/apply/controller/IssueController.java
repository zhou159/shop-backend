package com.zhou.shop.apply.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.zhou.shop.api.dto.IssueDTO;
import com.zhou.shop.api.entity.Issue;
import com.zhou.shop.apiServer.service.IIssueService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public RestObject<String> createIssue(@Valid @RequestBody Issue issue) {
        return iIssueService.createIssue(issue);
    }

    @ApiOperation("按id查询问题")
    @GetMapping("/retrieveByIssueId/{issueId}")
    public RestObject<Issue> retrieveByIssueId(@PathVariable String issueId) {
        return iIssueService.retrieveByIssueId(issueId);
    }

    @ApiOperation("查询全部未解决的问题")
    @GetMapping("/retrieveAllIssue")
    public RestObject<List<IssueDTO>> retrieveAllIssue() {
        return iIssueService.retrieveAllIssue();
    }

    @SaCheckLogin
    @ApiOperation("按id修改问题")
    @PostMapping("/updateIssueByIssueId/{userId}")
    public RestObject<String> updateIssueByIssueId(
            @PathVariable("userId") String userId, @RequestBody Issue issue) {
        return iIssueService.updateIssueByIssueId(userId, issue);
    }

    @SaCheckRole("superAdmin")
    @ApiOperation("按id删除问题")
    @PostMapping("/deleteByIssueId/{issueId}")
    public RestObject<String> deleteIssueById(@PathVariable String issueId) {
        return iIssueService.deleteIssueById(issueId);
    }

    @ApiOperation("根据问题描述模糊查询")
    @PostMapping("/retrieveByIssueDescription")
    public RestObject<List<IssueDTO>> retrieveByIssueDescription(@RequestBody Issue issue) {
        return iIssueService.retrieveByIssueDescription(issue.getIssueDescription());
    }

    @SaCheckLogin
    @ApiOperation("修改问题状态")
    @PostMapping("/updateIssueStatus/{issueId}")
    public RestObject<String> updateIssueStatus(
            @PathVariable String issueId,@Valid @RequestBody Issue issue) {
        return iIssueService.updateIssueStatus(issueId, issue.getIssueStatus());
    }

    @SaCheckLogin
    @ApiOperation("根据用户id查询问题信息")
    @PostMapping("/retrieveByUserId/{userId}")
    public RestObject<List<IssueDTO>> retrieveByUserId(@PathVariable String userId) {
        return iIssueService.retrieveByUserId(userId);
    }
}

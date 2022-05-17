package com.zhou.shop.controller;

import com.zhou.shop.dto.IssueModuleDto;
import com.zhou.shop.entity.Issue;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.service.IIssueService;
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
public class IssueController {
    private final IIssueService iIssueService;

    public IssueController(IIssueService iIssueService) {
        this.iIssueService = iIssueService;
    }

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

    @ApiOperation("按id修改问题")
    @PostMapping("/updateIssueByIssueId/{issueId}")
    public RestObject<String> updateIssueByIssueId(@PathVariable String issueId, @RequestBody Issue issue) {
        return iIssueService.updateIssueByIssueId(issueId, issue);
    }

    @ApiOperation("按id删除问题")
    @PostMapping("/deleteByIssueId/{issueId}")
    public RestObject<String> deleteIssueById(@PathVariable String issueId) {
        return iIssueService.deleteIssueById(issueId);
    }

    @ApiOperation("查询全部问题板块")
    @GetMapping("/issueModule")
    public RestObject<List<IssueModuleDto>> getIssueModule() {
        return iIssueService.getIssueModule();
    }

    @ApiOperation("根据问题描述模糊查询")
    @PostMapping("/retrieveByIssueDescription")
    public RestObject<List<Issue>> retrieveByIssueDescription(@RequestBody Issue issue) {
        return iIssueService.retrieveByIssueDescription(issue.getIssueDescription());
    }

    @ApiOperation("修改问题状态")
    @PostMapping("/updateIssueStatus/{issueId}")
    public RestObject<String> updateIssueStatus(@PathVariable String issueId, @RequestBody Issue issue) {
        return iIssueService.updateIssueStatus(issueId, issue.getIssueStatus());
    }
}

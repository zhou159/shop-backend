package com.zhou.shop.controller;

import com.zhou.shop.dto.IssueModuleDto;
import com.zhou.shop.entity.Issue;
import com.zhou.shop.enums.LogStatus;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IIssueService;
import com.zhou.shop.util.LogUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    final LogUtil logUtil;
    final IIssueService iIssueService;

    public IssueController(IIssueService iIssueService, LogUtil logUtil) {
        this.iIssueService = iIssueService;
        this.logUtil = logUtil;
    }

    @ApiOperation("新增问题")
    @PostMapping("/createIssue")
    public RestObject<String> createIssue(@RequestBody Issue issue) {
        issue.setIssueCreateTime(LocalDateTime.now());
        issue.setIssueStatus("0");
        boolean save = iIssueService.save(issue);
        if (save) {
            logUtil.log("新增了一个问题", LogStatus.INFO.info);
            return RestResponse.makeOkRsp("新增成功！");
        } else {
            logUtil.log("新增问题出现异常", LogStatus.ERROR.info);
            return RestResponse.makeErrRsp("新增成功！");
        }
    }

    @ApiOperation("按id查询问题")
    @GetMapping("/retrieveByIssueId/{issueId}")
    public RestObject<Issue> retrieveByIssueId(@PathVariable String issueId) {
        Issue issue = iIssueService.getById(issueId);
        logUtil.log("查询了问题信息，问题ID：" + issueId, LogStatus.INFO.info);
        return RestResponse.makeOkRsp(issue);
    }

    @ApiOperation("查询全部问题")
    @GetMapping("/retrieveAllIssue")
    public RestObject<List<Issue>> retrieveAllIssue() {
        List<Issue> list = iIssueService.list();
        logUtil.log("查询了全部问题信息", LogStatus.INFO.info);
        return RestResponse.makeOkRsp(list);
    }

    @ApiOperation("按id修改问题")
    @PostMapping("/updateIssueByIssueId/{issueId}")
    public RestObject<String> updateIssueByIssueId(
            @PathVariable String issueId, @RequestBody Issue issue) {
        issue.setIssueId(issueId);
        boolean b = iIssueService.updateById(issue);
        if (b) {
            logUtil.log("成功修改了信息信息，信息ID：" + issueId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("修改成功！");
        } else {
            logUtil.log("修改信息信息时失败，信息ID：" + issueId, LogStatus.ERROR.info);
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @ApiOperation("按id删除问题")
    @PostMapping("/deleteByIssueId/{issueId}")
    public RestObject<String> deleteIssueById(@PathVariable String issueId) {
        boolean b = iIssueService.removeById(issueId);
        if (b) {
            logUtil.log("成功删除了信息信息，信息ID：" + issueId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("删除成功！");
        } else {
            logUtil.log("删除信息信息时失败，信息ID：" + issueId, LogStatus.ERROR.info);
            return RestResponse.makeErrRsp("删除失败！");
        }
    }

    @ApiOperation("查询全部问题板块")
    @GetMapping("/issueModule")
    public RestObject<List<IssueModuleDto>> getIssueModule() {
        logUtil.log("查询了全部问题板块", LogStatus.INFO.info);
        return RestResponse.makeOkRsp(iIssueService.getIssueModule());
    }

    @ApiOperation("根据问题描述模糊查询")
    @PostMapping("/retrieveByIssueDescription")
    public RestObject<List<Issue>> retrieveByIssueDescription(@RequestBody Issue issue) {
        logUtil.log("根据问题描述模糊查询了问题，问题描述：" + issue.getIssueDescription(), LogStatus.INFO.info);
        return RestResponse.makeOkRsp(
                iIssueService.retrieveByIssueDescription(issue.getIssueDescription()));
    }
}

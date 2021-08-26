package com.zhou.shop.controller;

import com.zhou.shop.dto.IssueModuleDto;
import com.zhou.shop.entity.Issue;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IIssueService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * 前端控制器
 *
 * @author 周雄
 * @since 2021-06-24
 */
@RestController
@RequestMapping("/issue")
public class IssueController {

    final IIssueService iIssueService;

    public IssueController(IIssueService iIssueService) {
        this.iIssueService = iIssueService;
    }

    @PostMapping("/createIssue")
    public RestObject<String> createIssue(@RequestBody Issue issue) {
        issue.setIssueId(UUID.randomUUID().toString().replace("-","").toUpperCase());
        issue.setIssueCreateTime(LocalDateTime.now());
        issue.setIssueStatus("0");
        boolean save = iIssueService.save(issue);
        if (save) {
            return RestResponse.makeOkRsp("新增成功！");
        } else {
            return RestResponse.makeErrRsp("新增成功！");
        }
    }

    @GetMapping("/retrieveByIssueId/{issueId}")
    public RestObject<Issue> retrieveByIssueId(@PathVariable String issueId) {
        Issue issue = iIssueService.getById(issueId);
        return RestResponse.makeOkRsp(issue);
    }

    @GetMapping("/retrieveAllIssue")
    public RestObject<List<Issue>> retrieveAllIssue() {
        List<Issue> list = iIssueService.list();
        return RestResponse.makeOkRsp(list);
    }

    @PostMapping("/updateIssueByIssueId/{issueId}")
    public RestObject<String> updateIssueByIssueId(@PathVariable String issueId, @RequestBody Issue issue) {
        issue.setIssueId(issueId);
        boolean b = iIssueService.updateById(issue);
        if (b) {
            return RestResponse.makeOkRsp("修改成功！");
        } else {
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @PostMapping("/deleteByIssueId/{issueId}")
    public RestObject<String> deleteIssueById(@PathVariable String issueId) {
        boolean b = iIssueService.removeById(issueId);
        if (b) {
            return RestResponse.makeOkRsp("删除成功！");
        } else {
            return RestResponse.makeErrRsp("删除失败！");
        }
    }

    @GetMapping("/issueModule")
    public RestObject<List<IssueModuleDto>> getIssueModule(){
        return RestResponse.makeOkRsp(iIssueService.getIssueModule());
    }

    @PostMapping("/retrieveByIssueDescription")
    public RestObject<List<Issue>> retrieveByIssueDescription(@RequestBody Issue issue){
        return RestResponse.makeOkRsp(iIssueService.retrieveByIssueDescription(issue.getIssueDescription()));
    }
}

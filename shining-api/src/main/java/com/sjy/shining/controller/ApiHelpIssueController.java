package com.sjy.shining.controller;

import com.sjy.shining.annotation.IgnoreAuth;
import com.sjy.shining.entity.HelpIssueVo;
import com.sjy.shining.entity.HelpTypeVo;
import com.sjy.shining.service.ApiHelpIssueService;
import com.sjy.shining.service.ApiHelpTypeService;
import com.sjy.shining.utils.ApiBaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 */
@RestController
@RequestMapping("api/helpissue")
public class ApiHelpIssueController extends ApiBaseAction {
    @Autowired
    private ApiHelpIssueService helpIssueService;
    @Autowired
    private ApiHelpTypeService helpTypeService;

    /**
     * 查看帮助类型列表
     */
    @RequestMapping("/typeList")
    @IgnoreAuth
    public Object typeList() {

        List<HelpTypeVo> list = helpTypeService.queryList(new HashMap());

        return toResponsSuccess(list);
    }

    /**
     * 查看问题列表
     */
    @RequestMapping("/issueList")
    @IgnoreAuth
    public Object issueList(Long type_id) {

        Map params = new HashMap();
        params.put("type_id", type_id);
        List<HelpIssueVo> helpIssueList = helpIssueService.queryList(params);

        return toResponsSuccess(helpIssueList);
    }
}

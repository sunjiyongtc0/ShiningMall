package com.sjy.shining.controller;

import com.alibaba.fastjson.JSONObject;
import com.sjy.shining.annotation.LoginUser;
import com.sjy.shining.entity.FeedbackVo;
import com.sjy.shining.entity.UserVo;
import com.sjy.shining.service.ApiFeedbackService;
import com.sjy.shining.utils.ApiBaseAction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 描述: ApiFeedbackController <br>
 */
@Api(tags = "反馈")
@RestController
@RequestMapping("/api/feedback")
public class ApiFeedbackController extends ApiBaseAction {
    @Autowired
    private ApiFeedbackService feedbackService;

    /**
     * 添加反馈
     */
    @ApiOperation(value = "添加反馈")
    @PostMapping("save")
    public Object save(@LoginUser UserVo loginUser) {
        JSONObject feedbackJson = super.getJsonRequest();
        if (null != feedbackJson) {
            FeedbackVo feedbackVo = new FeedbackVo();
            feedbackVo.setUserId(loginUser.getUserId().intValue());
            feedbackVo.setUserName(loginUser.getUsername());
            feedbackVo.setMobile(feedbackJson.getString("mobile"));
            feedbackVo.setFeedType(feedbackJson.getInteger("index"));
            feedbackVo.setStatus(1);
            feedbackVo.setContent(feedbackJson.getString("content"));
            feedbackVo.setAddTime(new Date());
            feedbackService.save(feedbackVo);
            return super.toResponsSuccess("感谢你的反馈");
        }
        return super.toResponsFail("反馈失败");
    }
}
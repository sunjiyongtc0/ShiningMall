package com.sjy.shining.controller;

import com.sjy.shining.annotation.IgnoreAuth;
import com.sjy.shining.entity.SysSmsLogEntity;
import com.sjy.shining.service.SysSmsLogService;
import com.sjy.shining.utils.R;
import com.sjy.shining.utils.RRException;
import com.sjy.shining.utils.RequestUtil;
import com.sjy.shining.utils.ResourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 发送短信接口Controller
 *
 */
@RestController
@RequestMapping("api")
public class ApiSmsController {
    @Autowired
    private SysSmsLogService smsLogService;

    /**
     * 发送短信
     *
     * @param request request
     * @param params 请求参数{mobile：电话号码字符串，中间用英文逗号间隔,content：内容字符串,stime：追加发送时间，可为空，为空为及时发送}
     * @return R
     */
    @IgnoreAuth
    @RequestMapping("/sendSms")
    public R sendSms(HttpServletRequest request, @RequestParam Map<String, String> params) {
        SysSmsLogEntity smsLog = new SysSmsLogEntity();
        String validIP = RequestUtil.getIpAddrByRequest(request);
        if (ResourceUtil.getConfigByName("sms.validIp").indexOf(validIP) < 0) {
            throw new RRException("非法IP请求！");
        }
        smsLog.setMobile(params.get("mobile"));

        //todo 模板ID：实际使用需要修改
        smsLog.setTemplateId(23);
        smsLog.setCode(params.get("code"));
        SysSmsLogEntity sysSmsLogEntity = smsLogService.sendSms(smsLog);
        return R.ok().put("result", sysSmsLogEntity);
    }
}

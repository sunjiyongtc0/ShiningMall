package com.sjy.shining.service.impl;

//import com.github.qcloudsms.SmsSingleSenderResult;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.shining.dao.SysSmsLogDao;
import com.sjy.shining.dao.SysUserRoleDao;
import com.sjy.shining.entity.SmsConfig;
import com.sjy.shining.entity.SysSmsLogEntity;
import com.sjy.shining.entity.SysUserRoleEntity;
import com.sjy.shining.service.SysConfigService;
import com.sjy.shining.service.SysSmsLogService;
import com.sjy.shining.service.SysUserRoleService;
import com.sjy.shining.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("smsLogService")
public class SysSmsLogServiceImpl extends ServiceImpl<SysSmsLogDao, SysSmsLogEntity> implements SysSmsLogService {

    @Autowired
    private SysConfigService sysConfigService;


    @Override
    public SysSmsLogEntity sendSms(SysSmsLogEntity smsLog) {
//        //获取云存储配置信息
//        SmsConfig config = sysConfigService.getConfigObject(Constant.SMS_CONFIG_KEY, SmsConfig.class);
//        if (StringUtils.isNullOrEmpty(config)) {
//            throw new RRException("请先配置短信平台信息");
//        }
//        if (StringUtils.isNullOrEmpty(config.getAppid())) {
//            throw new RRException("请先配置短信平台APPID");
//        }
//        if (StringUtils.isNullOrEmpty(config.getAppkey())) {
//            throw new RRException("请先配置短信平台KEY");
//        }
//        if (StringUtils.isNullOrEmpty(config.getSign())) {
//            throw new RRException("请先配置短信平台签名");
//        }
//        SmsSingleSenderResult result;
//        try {
//            /**
//             * 状态,发送编号,无效号码数,成功提交数,黑名单数和消息，无论发送的号码是多少，一个发送请求只返回一个sendid，如果响应的状态不是“0”，则只有状态和消息
//             */
//            result = SmsUtil.crSendSms(config.getAppid(), config.getAppkey(), smsLog.getMobile(), smsLog.getTemplateId(), new String[]{smsLog.getCode()}, smsLog.getSign());
//
//            //发送成功
//            if (result.result == 0) {
//                smsLog.setSendId(result.sid);
//                smsLog.setSuccessNum(1);
//                smsLog.setReturnMsg(result.errMsg);
//            } else {
//                //发送失败
//                smsLog.setReturnMsg(result.errMsg);
//            }
//        } catch (Exception e) {
//            throw new RRException("短信发送失败");
//        }
//        smsLog.setSendStatus(result.result);
//        try {
//            smsLog.setUserId(ShiroUtils.getUserId());
//        } catch (Exception e) {
//            //外部发送短信
//            smsLog.setUserId(1L);
//        }
//        smsLog.setSign(config.getSign());
//        //保存发送记录
//        save(smsLog);
        return smsLog;
    }
}

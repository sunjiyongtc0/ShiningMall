package com.sjy.shining.dao;

import com.sjy.shining.entity.SmsLogVo;
import com.sjy.shining.entity.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户
 *
 */
@Mapper
public interface ApiUserMapper extends BaseDao<UserVo> {

    UserVo queryByMobile(String mobile);

    UserVo queryByOpenId(@Param("openId") String openId);

    /**
     * 获取用户最后一条短信
     *
     * @param user_id
     * @return
     */
    SmsLogVo querySmsCodeByUserId(@Param("user_id") Long user_id);

    /**
     * 保存短信
     *
     * @param smsLogVo
     * @return
     */
    int saveSmsCodeLog(SmsLogVo smsLogVo);
}

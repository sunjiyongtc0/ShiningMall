package com.sjy.shining.controller;

import com.sjy.shining.entity.SysUserEntity;
import com.sjy.shining.shiro.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 *
 */
public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUserEntity getUser() {
        return ShiroUtils.getUserEntity();
    }

    protected Long getUserId() {
        return getUser().getUserId();
    }

    protected Long getDeptId() {
        return getUser().getDeptId();
    }
}

package com.sjy.shining.controller;


import com.sjy.shining.annotation.SysLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysController  {


    @SysLog("主页面")
    @RequestMapping(value = {"/", "index.html"})
    public String index(){
        return "index";
    }

    @SysLog("概述页面")
    @RequestMapping(value = {"/", "sys/main.html"})
    public String main(){
        return "page/sys/main";
    }

    @SysLog("短信配置页面")
    @RequestMapping(value = {"/", "sys/smslog.html"})
    public String smslog(){
        return "page/sys/smslog";
    }


    @SysLog("用户页面")
    @RequestMapping(value = {"/", "sys/user.html"})
    public String user(){
        return "page/sys/user";
    }

    @SysLog("角色页面")
    @RequestMapping(value = {"/", "sys/role.html"})
    public String role(){
        return "page/sys/role";
    }

    @SysLog("部门页面")
    @RequestMapping(value = {"/", "sys/dept.html"})
    public String dept(){
        return "page/sys/dept";
    }

    @SysLog("菜单页面")
    @RequestMapping(value = {"/", "sys/menu.html"})
    public String menu(){
        return "page/sys/menu";
    }

    @SysLog(" 定时任务页面")
    @RequestMapping(value = {"/", "sys/schedule.html"})
    public String schedule(){
        return "page/sys/schedule";
    }

    @SysLog(" 定时任务日志页面")
    @RequestMapping(value = {"/", "sys/schedule_log.html"})
    public String scheduleLog(){
        return "page/sys/schedule_log";
    }

    @SysLog("文件上传页面")
    @RequestMapping(value = {"/", "sys/oss.html"})
    public String oss(){
        return "page/sys/oss";
    }

    @SysLog("字典页面")
    @RequestMapping(value = {"/", "sys/macro.html"})
    public String macro(){
        return "page/sys/macro";
    }

    @SysLog("图形页面")
    @RequestMapping(value = {"/", "sys/icon.html"})
    public String icon(){
        return "page/sys/icon";
    }

    @SysLog("系统配置页面")
    @RequestMapping(value = {"/", "sys/config.html"})
    public String config(){
        return "page/sys/config";
    }

    @SysLog("系统日志页面")
    @RequestMapping(value = {"/", "sys/log.html"})
    public String log(){
        return "page/sys/log";
    }

    @SysLog("系统地区页面")
    @RequestMapping(value = {"/", "sys/region.html"})
    public String region(){
        return "page/sys/region";
    }

    @SysLog("系统代码页面")
    @RequestMapping(value = {"/", "sys/generator.html"})
    public String generator(){
        return "page/sys/generator";
    }

    @SysLog("iviewDemo页面")
    @RequestMapping(value = {"/", "test/iviewDemo.html"})
    public String test(){
        return "page/test/iviewDemo";
    }
}

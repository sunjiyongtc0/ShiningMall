package com.sjy.shining.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sjy.shining.entity.TopicEntity;
import com.sjy.shining.service.TopicService;
import com.sjy.shining.utils.PageUtils;
import com.sjy.shining.utils.Query;
import com.sjy.shining.utils.R;

/**
 * Controller
 *
 */
@RestController
@RequestMapping("topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("topic:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<TopicEntity> topicList = topicService.queryList(query);
        int total = topicService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(topicList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("topic:info")
    public R info(@PathVariable("id") Integer id) {
        TopicEntity topic = topicService.queryObject(id);

        return R.ok().put("topic", topic);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("topic:save")
    public R save(@RequestBody TopicEntity topic) {
        topicService.save(topic);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("topic:update")
    public R update(@RequestBody TopicEntity topic) {
        topicService.update(topic);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("topic:delete")
    public R delete(@RequestBody Integer[] ids) {
        topicService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<TopicEntity> list = topicService.queryList(params);

        return R.ok().put("list", list);
    }
}

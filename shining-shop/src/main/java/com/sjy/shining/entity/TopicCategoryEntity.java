package com.sjy.shining.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


/**
 * 实体
 * 表名 nideshop_topic_category
 *
 */
@Data
@TableName("nideshop_topic_category")
public class TopicCategoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    @TableId
    private Integer id;
    //活动类别主题
    private String title;
    //活动类别图片链接
    private String picUrl;

    /**
     * 设置：主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：活动类别主题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取：活动类别主题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置：活动类别图片链接
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * 获取：活动类别图片链接
     */
    public String getPicUrl() {
        return picUrl;
    }
}

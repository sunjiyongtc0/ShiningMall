package com.sjy.shining.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


/**
 * 实体
 * 表名 nideshop_attribute_category
 */

@Data
@TableName("nideshop_attribute_category")
public class AttributeCategoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;
    //
    private String name;
    //
    private Integer enabled;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取：
     */
    public Integer getEnabled() {
        return enabled;
    }
}

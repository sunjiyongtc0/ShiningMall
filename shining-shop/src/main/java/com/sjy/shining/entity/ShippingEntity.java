package com.sjy.shining.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


/**
 * 实体
 * 表名 nideshop_shipping
 *
 */
@Data
@TableName("nideshop_shipping")
public class ShippingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    @TableId
    private Integer id;
    //
    private String code;
    //
    private String name;

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
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取：
     */
    public String getCode() {
        return code;
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
}

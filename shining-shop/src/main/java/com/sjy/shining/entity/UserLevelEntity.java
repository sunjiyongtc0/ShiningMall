package com.sjy.shining.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;


/**
 * 实体
 * 表名 nideshop_user_level
 *
 */
@Data
@TableName("nideshop_user_level")
public class UserLevelEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    @TableId
    private Integer id;
    //
    private String name;
    //
    private String description;

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
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取：
     */
    public String getDescription() {
        return description;
    }
}

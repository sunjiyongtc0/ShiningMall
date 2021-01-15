package com.sjy.shining.entity;

import java.io.Serializable;


/**
 * 规格表
 *
 */
public class SpecificationVo implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //规范名称
    private String name;
    //排序
    private Integer sort_order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort_order() {
        return sort_order;
    }

    public void setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
    }
}

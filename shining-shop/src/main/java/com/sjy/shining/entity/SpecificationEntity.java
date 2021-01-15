package com.sjy.shining.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 规格表
 * 
 */
@Data
@TableName("nideshop_specification")
public class SpecificationEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	@TableId
	private Integer id;
	//规范名称
	private String name;
	//排序
	private Integer sortOrder;

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
	 * 设置：规范名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：规范名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：排序
	 */
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSortOrder() {
		return sortOrder;
	}
}

package com.sjy.shining.entity;

import java.io.Serializable;


/**
 * 商城_用户级别
 * 
 */
public class UserLevelVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//名称
	private String name;
	//描述
	private String description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

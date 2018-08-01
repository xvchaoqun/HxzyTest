package com.tfx.spring.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;

public class BaseDao {
	protected SqlSessionTemplate template;

	public SqlSessionTemplate getTemplate() {
		return template;
	}

	@Resource
	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}
	
}

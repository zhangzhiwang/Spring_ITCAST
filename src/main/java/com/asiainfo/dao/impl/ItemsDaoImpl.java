package com.asiainfo.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.asiainfo.dao.IItemsDao;

/**
 * 商品Dao接口实现
 *
 * @author zhangzhiwang
 * @date 2017年7月25日 下午12:43:09
 */
public class ItemsDaoImpl implements IItemsDao {
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void add() {
		jdbcTemplate.update("insert into items (name) values (?)", "name1");
	}

}

package com.asiainfo.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * spring对jdbc的支持</br>
 * spring对jdbc的支持表现在两个方面：</br>
 * 1、spring对数据库连接池的支持</br>
 * 2、spring提供了jdbc模板来简化对jdbc的操作
 *
 * @author zhangzhiwang
 * @date 2017年7月16日 下午5:48:19
 */
public class SpringJdbc {
	/** jdbc模板，spring对jdbc的支持 */
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 对于原始的jdbc操作，spring是如何一步步简化的，可以参考itcast视频：Spring/02_代理模式、AOP编程、jdbc支持/视频/8.spring对jdbc模块支持.avi
	 */

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save() {
		jdbcTemplate.update("insert into user (username) values ('JdbcTemplate')");
	}

	public void query() {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user"); // 查询出来的每条记录是一个Map，如果要将每条记录放到实体里面需要手动实现，这也就是为什么要用orm框架
		System.out.println(list);
	}
}

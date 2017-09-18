package com.asiainfo.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring对jdbc的支持测试类
 *
 * @author zhangzhiwang
 * @date 2017年7月16日 下午6:19:25
 */
public class SpringJdbcTest {
	private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_zzw.xml");
	
	
//	@Test
//	public void testSave() {
//		SpringJdbc springJdbc = (SpringJdbc) applicationContext.getBean("springJdbc");
//		springJdbc.save();
//	}

	@Test
	public void testQuery() {
		SpringJdbc springJdbc = (SpringJdbc) applicationContext.getBean("springJdbc");
		springJdbc.query();
	}

}

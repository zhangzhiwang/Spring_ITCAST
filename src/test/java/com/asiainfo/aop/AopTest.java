package com.asiainfo.aop;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.dao.IUserDao;

/**
 * 手工实现AOP编程
 *
 * @author zhangzhiwang
 * @date 2017年7月3日 下午2:14:38
 */
public class AopTest {

	@Test
	public void testGetProxyInstance() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_zzw.xml");
		Aop aop = (Aop) applicationContext.getBean("aop");
		IUserDao userDao = (IUserDao) aop.getProxyInstance();
		userDao.queryById(0);
	}

}

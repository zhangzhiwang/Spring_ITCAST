package com.asiainfo.proxy;

import static org.junit.Assert.*;

import org.junit.Test;

import com.asiainfo.dao.impl.UserDaoImpl;
import com.asiainfo.entity.User;

/**
 * 动态代理测试
 *
 * @author zhangzhiwang
 * @date 2017年7月2日 下午3:11:59
 */
public class StaticProxyTest {

	@Test
	public void testQueryById() {
		StaticProxy staticProxy = new StaticProxy(new UserDaoImpl());
		User user = staticProxy.queryById(0);
		System.out.println(user);
	}

}

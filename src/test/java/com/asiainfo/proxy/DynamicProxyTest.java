package com.asiainfo.proxy;

import static org.junit.Assert.*;

import org.junit.Test;

import com.asiainfo.dao.IUserDao;
import com.asiainfo.dao.impl.UserDaoImpl;
import com.asiainfo.entity.User;

/**
 * 静态代理测试
 *
 * @author zhangzhiwang
 * @date 2017年7月2日 下午3:12:10
 */
public class DynamicProxyTest {

	@Test
	public void testGetProxyInstance() {
		UserDaoImpl target = new UserDaoImpl();
		DynamicProxy dynamicProxy = new DynamicProxy(target);
		IUserDao userDaoProxy = (IUserDao) dynamicProxy.getProxyInstance();
//		User user = userDaoProxy.queryById(0);
//		System.out.println(user);
		userDaoProxy.save(new User());
	}

}

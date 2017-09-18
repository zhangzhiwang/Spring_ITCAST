package com.asiainfo.proxy;

import static org.junit.Assert.*;

import org.junit.Test;

import com.asiainfo.dao.IUserDao;
import com.asiainfo.dao.impl.UserDaoImpl;
import com.asiainfo.entity.User;

/**
 * cglib代理测试
 *
 * @author zhangzhiwang
 * @date 2017年7月2日 下午10:05:19
 */
public class CglibProxyTest {

	@Test
	public void testGetProxyInstance() {
		CglibProxy cglibProxy = new CglibProxy(new UserDaoImpl());
		IUserDao userDao = (IUserDao) cglibProxy.getProxyInstance();
		userDao.save(new User());
	}

}

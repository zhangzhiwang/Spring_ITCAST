package com.asiainfo.proxy;

import com.asiainfo.dao.IUserDao;
import com.asiainfo.dao.impl.UserDaoImpl;
import com.asiainfo.entity.User;

/**
 * 静态代理</br>
 * 步骤：</br>
 * 1、静态代理类要实现目标对象类所实现的接口</br>
 * 2、静态代理类包含目标对象，即目标对象为其属性</br>
 * 3、静态代理类的接口实现方法里面要用目标对象去掉用该方法</br>
 * </br>
 * 优点：</br>
 * 可以在不改变目标对象的基础上实现一些额外的功能，符合开闭原则</br>
 * </br>
 * 缺点：</br>
 * 1、由于静态代理类实现了与目标对象类同样的接口，所以，当接口发生变化时静态代理类也要跟着变化</br>
 * 2、一个子类对应一个代理类，随着接口和是实现类的增多，代理类也随之增加
 *
 * @author zhangzhiwang
 * @date 2017年7月2日 下午2:50:55
 */
public class StaticProxy implements IUserDao {
	private UserDaoImpl userDaoImpl;

	public StaticProxy() {
		super();
	}

	public StaticProxy(UserDaoImpl userDaoImpl) {
		super();
		this.userDaoImpl = userDaoImpl;
	}

	public User queryById(int id) {
		System.out.println("开启事务");

		User user = userDaoImpl.queryById(id);

		System.out.println("关闭事物");
		return user;
	}

	public UserDaoImpl getUserDaoImpl() {
		return userDaoImpl;
	}

	public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	public void save(User user) {
	}

	public void save() {

	}

}

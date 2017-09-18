package com.asiainfo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asiainfo.dao.IItemsDao;
import com.asiainfo.dao.IUserDao;
import com.asiainfo.entity.User;
import com.asiainfo.service.IUserService;

/**
 * 用户服务接口实现
 *
 * @author zhangzhiwang
 * @date 2017年6月25日 下午12:36:38
 */
//@Component(value="userServiceImpl123")
@Repository       //@Service标明该类是一个spring的bean，id为userServiceImpl，同时标明该类是业务层
@Transactional   //该类的所有方法都使用事务
public class UserServiceImpl implements IUserService {
	@Resource  //如果将@Resource后面的（）去掉，则是按类型注入。一般不使用按类型注入的方式
	private IUserDao userDao;
	@Resource
	private IItemsDao itemsDao;
	
	public void setItemsDao(IItemsDao itemsDao) {
		this.itemsDao = itemsDao;
	}

	public User queryById(int id) {
		System.out.println("service:执行业务逻辑，调用dao");
		return userDao.queryById(id);
	}

//	public IUserDao getUserDao() {
//		return userDao;
//	}

//	public void setUserDao(IUserDao userDao) {
//		this.userDao = userDao;
//	}
	
//	@Transactional   //只在该方法使用事务   在spring4.0上面测试未通过
	public void meth1() {
		userDao.save();
		String s = null;
		s.length();
		itemsDao.add();
	}

	public void meth2() {
		userDao.save();
		String s = null;
		s.length();
		itemsDao.add();
	}

}

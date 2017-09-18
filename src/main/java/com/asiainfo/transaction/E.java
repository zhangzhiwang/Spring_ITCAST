package com.asiainfo.transaction;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asiainfo.dao.IItemsDao;
import com.asiainfo.dao.IUserDao;

@Component
public class E extends D {
	@Resource
	private IUserDao userDao;
	@Resource
	private IItemsDao itemsDao;

	public void met1() {
		System.out.println("e.met1()");
		userDao.save();
		String s = null;
		s.length();
		itemsDao.add();
	}
	
	public void met2() {
		System.out.println("e.met2()");
		userDao.save();
		String s = null;
		s.length();
		itemsDao.add();
	}
	
	@Transactional(readOnly = false,timeout = -1,
//			noRollbackFor = NullPointerException.class,   //遇到指定异常不回滚
//			noRollbackForClassName = "java.lang.NullPointerException",   //同上
//			rollbackFor = ArithmeticException.class,    //遇到指定异常才回滚    在spring 4上测试未通过，不起作用
//			rollbackForClassName = "java.lang.ArithmeticException",  //同上，同样测试不通过
			propagation = Propagation.REQUIRED  //某方法A在事务内执行，该方法调用了另一个带有事务的方法B，propagation = Propagation.REQUIRED表示B方法的事务加入到A方法的事务中来执行。
												//假如B方法执行完后，A方法的后续逻辑抛出了异常，则B方法同样会回滚
//			propagation = Propagation.REQUIRES_NEW   //某方法A在事务内执行，该方法调用了另一个带有事务的方法B，如果方法B的事务是Propagation.REQUIRES_NEW，则无论如何B都会开启一个新的事务。
												//假如B方法执行完后，A方法的后续逻辑抛出了异常，则B方法不会回滚，因为A和B在不同的事务内运行
			)
	public void met3() {
		System.out.println("e.met3()");
		userDao.save();
		String s = null;
		s.length();
		itemsDao.add();
	}
}

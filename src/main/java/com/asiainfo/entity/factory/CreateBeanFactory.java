package com.asiainfo.entity.factory;

import com.asiainfo.entity.User;

/**
 * bean工厂
 *
 * @author zhangzhiwang
 * @date 2017年6月23日 下午11:49:00
 */
public class CreateBeanFactory {
	private CreateBeanFactory() {}
	
	public User getInstance() {
		System.out.println("工厂的普通方法");
		return new User();
	}
	
	public static User getStaticInstance() {
		System.out.println("工厂的静态方法");
		return new User();
	}
}

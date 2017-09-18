package com.asiainfo.service;

import com.asiainfo.entity.User;

/**
 * 用户服务接口
 *
 * @author zhangzhiwang
 * @date 2017年6月25日 下午12:35:36
 */
public interface IUserService {
	/**
	 * 通过id查询用户
	 * 
	 * @param id
	 * @return
	 * @author zhangzhiwang
	 * @date 2017年6月25日 下午12:35:58
	 */
	User queryById(int id);
	void meth1();
	void meth2();
}

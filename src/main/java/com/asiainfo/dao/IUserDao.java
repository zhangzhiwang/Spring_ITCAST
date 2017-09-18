package com.asiainfo.dao;

import com.asiainfo.entity.User;

/**
 * 用户Dao接口
 *
 * @author zhangzhiwang
 * @date 2017年6月25日 下午12:32:38
 */
public interface IUserDao {
	/**
	 * 通过主键查询用户
	 * 
	 * @param id
	 * @return
	 * @author zhangzhiwang
	 * @date 2017年6月25日 下午12:33:30
	 */
	User queryById(int id);

	/**
	 * 保存用户
	 * 
	 * @param user
	 * @author zhangzhiwang
	 * @date 2017年7月2日 下午9:10:16
	 */
	void save(User user);

	void save();
}

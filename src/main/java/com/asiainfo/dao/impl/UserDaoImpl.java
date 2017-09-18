package com.asiainfo.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asiainfo.dao.IUserDao;
import com.asiainfo.entity.User;

/**
 * 用户dao接口实现
 *
 * @author zhangzhiwang
 * @date 2017年6月25日 下午12:35:00
 */
//@Component(value="userDaoImpl_zzw")    //声明该类是spring的一个组件（bean），相当于<bean id="userDaoImpl_zzw" class="com.asiainfo.dao.impl.UserDaoImpl"></bean>
//@Component("userDaoImpl")            //value属性可以省略
@Component                              //去掉（）里面的值，spring默认将首字母小写的类名作为bean的id，即这里声明该类是一个bean，id为userDaoImpl
//@Controller                              //@Repository声明该类是一个bean，id为userDaoImpl，同时也表示该类是DAO层
public class UserDaoImpl implements IUserDao {
	@Resource
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public User queryById(int id) {
		System.out.println("dao:访问数据库，查询数据");
		return new User(102, "aaa");
	}

	public void save(User user) {
		jdbcTemplate.update("insert into user (username) values (?)", "name1");
		System.out.println("用户已保存");
//		throw new RuntimeException("目标方法抛异常！");
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void save() {
		jdbcTemplate.update("insert into user (username) values (?)", "name1");
		System.out.println("无参save()用户已保存");
	}

}

package com.asiainfo.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.asiainfo.entity.User;
import com.asiainfo.service.IUserService;

/**
 * 用户action
 *
 * @author zhangzhiwang
 * @date 2017年6月25日 下午12:37:46
 */
@Service // @Controller声明嘎勒为一个spring的bean，id为userAction，同时表明该类是控制层。在类上面使用注解解决的是ioc问题
// 注意：@Controller、@Service、@Repository实际上都可以用@Component来取代，之所以区分出来是因为方便程序员阅读，这样类层次关系一目了然，而对于spring而言，这三种注解可以混淆使用
public class UserAction {
	/**
	 * @Resource相当于： <bean id="userAction" class="com.asiainfo.action.UserAction"> <property name="userService" ref="userServiceImpl"></property> </bean>
	 */
	@Resource(name = "userServiceImpl") // 在属性上面使用注解解决的是DI问题。本例中@Resource将去引用id为userServiceImpl的bean将其注入到属性名为userService中，即注解中那么、属性的值一定是另一个bean的id
	private IUserService userService;

	public UserAction() {
		super();
	}

	public UserAction(IUserService userService) {
		super();
		this.userService = userService;
	}

	public User queryById(int id) {
		System.out.println("action接受前台数据，调用业务逻辑service");
		return userService.queryById(id);
	}
	//
	// public IUserService getUserService() {
	// return userService;
	// }

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		String s = "{FlowControlUsedRate>=0}";
		int begin = s.indexOf("{FlowControlUsedRate");
		int end = s.indexOf("}", begin);
		System.out.println(begin);
		System.out.println(end);
		System.out.println(s.substring(begin + 20, end));
		
		
	}
	
}

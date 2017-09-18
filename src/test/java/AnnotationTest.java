import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.action.UserAction;
import com.asiainfo.dao.impl.UserDaoImpl;
import com.asiainfo.entity.User;
import com.asiainfo.service.impl.UserServiceImpl;

/**
 * spring注解测试
 *
 * @author zhangzhiwang
 * @date 2017年6月26日 下午8:43:00
 */
public class AnnotationTest {
	@Test
	public void test() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_zzw.xml");
//		applicationContext.getBean("userDaoImpl");
//		System.out.println(userDaoImpl);
		
//		UserServiceImpl userServiceImpl = (UserServiceImpl) applicationContext.getBean("userServiceImpl");
//		System.out.println(userServiceImpl);
		
		UserAction userAction = (UserAction) applicationContext.getBean("userAction");
////		System.out.println(userAction);
		User user = userAction.queryById(0);
		System.out.println(user);
	}
}

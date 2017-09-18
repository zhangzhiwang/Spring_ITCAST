import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.action.UserAction;
import com.asiainfo.entity.User;

/**
 * 依赖注入测试
 *
 * @author zhangzhiwang
 * @date 2017年6月25日 下午12:14:02
 */
public class DependencyInjectionTest {
	@Test
	public void testDI() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_zzw.xml");
//		User user6 = (User) applicationContext.getBean("user6");
//		System.out.println(user6);
		
//		User user7 = (User) applicationContext.getBean("user7");
//		System.out.println(user7);
		
//		UserAction userAction = (UserAction) applicationContext.getBean("uA");
//		User user = userAction.queryById(0);
//		System.out.println(user);
		
//		UserAction userAction = (UserAction) applicationContext.getBean("uA_zzw");
//		User user = userAction.queryById(0);
//		System.out.println(user);
		
//		User user = (User) applicationContext.getBean("user8");
//		System.out.println(user);
		
		UserAction userAction = (UserAction) applicationContext.getBean("userAction");
		userAction.queryById(0);
	}
}

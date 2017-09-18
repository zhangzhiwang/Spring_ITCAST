import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.transaction.E;

/**
 * spring的事务测试
 *
 * @author zhangzhiwang
 * @date 2017年7月25日 下午12:52:35
 */
public class SpringTransactionTest {
	@Test
	public void testTransaction() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_zzw.xml");
		// IUserService userService = (IUserService) applicationContext.getBean("userServiceImpl");
		// userService.meth1();
		// userService.meth2();
//		E e1 = (E) applicationContext.getBean("e");
//		E e2 = applicationContext.getBean(E.class);// 按照bean的类型获取bean实例，注意容器里面只能有一个该类型的bean，否则报NoUniqueBeanDefinitionException
		E e2 = applicationContext.getBean("e2", E.class);
		System.out.println(e2);
		
		int count = applicationContext.getBeanDefinitionCount();
		System.out.println(count);
		
		String[] names = applicationContext.getBeanDefinitionNames();
		for(String str : names) {
			System.out.print(str + "\t");
		}
//		e.met1();
//		e.met2();
//		e.met3();
	}
}
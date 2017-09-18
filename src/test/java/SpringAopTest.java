import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.asiainfo.aop.D;
import com.asiainfo.aop.TestC;
import com.asiainfo.dao.IUserDao;
import com.asiainfo.dao.impl.OrderDaoImpl;

/**
 * spring的aop测试
 *
 * @author zhangzhiwang
 * @date 2017年7月16日 下午12:52:11
 */
public class SpringAopTest {
	@Test
	public void testSpringAop() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_zzw.xml");
		IUserDao userDao = (IUserDao) applicationContext.getBean("userDaoImpl");
		System.out.println(userDao.getClass());
		userDao.save();
//		System.out.println("--------");
//		userDao.queryById(0);
//
//		System.out.println("============");
//
//		OrderDaoImpl orderDaoImpl = (OrderDaoImpl) applicationContext.getBean("orderDaoImpl");// spring在生成代理对象的时候会自动根据目标对象所属类是否实现接口来决定用动态代理还是cglib代理
//		System.out.println(orderDaoImpl.getClass());
//		orderDaoImpl.insertOrder();
//		System.out.println("--------");
//		orderDaoImpl.delete();
	}
	
//	@Test
//	public void test() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_zzw.xml");
//		D c = (D) applicationContext.getBean("testC");
//		System.out.println(c.getClass());
//		IUserDao userDao = (IUserDao) applicationContext.getBean("userDaoImpl");
//		System.out.println(userDao.getClass());
//	}
}



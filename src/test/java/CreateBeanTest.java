import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.entity.User;

/**
 * bean创建的细节测试
 *
 * @author zhangzhiwang
 * @date 2017年6月23日 下午10:08:55
 */
public class CreateBeanTest {
	// @Test
	// public void test() {
	// //创建bean容器（应用程序上下文）
	// ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext_zzw.xml");
	// System.out.println("bean容器创建完成。");
	// //获得bean
	// User user1 = (User) classPathXmlApplicationContext.getBean("user1");
	// User user2 = (User) classPathXmlApplicationContext.getBean("user1");
	// classPathXmlApplicationContext.getBean("order1");
	//// System.out.println(user1);
	//// System.out.println(user2);
	//// System.out.println(user1 == user2);//bean默认为单例，即scope="singleton"，scope="prototype"为多例
	//
	// //在系统启动（创建应用程序上下文）之前，先按声明顺序创建未开启延迟初始化的单例bean，然后再创建上下文
	// //当单例模式开启延迟初始化后，会在需要（用到）的时候创建bean
	// //多例模式只有在需要的时候创建bean，因为bean（对象）可以创建多个，所以在初始化bean容器之前spring不知道要创建多少的实例对象，所以就不创建
	// //懒初始化只对单例起作用
	//
	// classPathXmlApplicationContext.destroy();
	// }

	@Test
	public void testCreateBean() {
		// 通过spring全局配置文件获取ioc容器（bean容器、应用程序上下文）
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_zzw.xml");
		// 通过默认（无参）构造方法实例化bean
//		User user2 = (User) applicationContext.getBean("user2");
//		System.out.println(user2);// 通过无参构造方法

		//通过有参构造器实例化bean
//		User user3 = (User) applicationContext.getBean("user3");
//		System.out.println(user3);
		
		//通过工厂构造bean
//		User user4 = (User) applicationContext.getBean("user4");//通过工厂的非静态方法构建
		User user5 = (User) applicationContext.getBean("user5");
	}
}

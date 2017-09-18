import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.asiainfo.entity.User;

/**
 * spring测试
 *
 * @author zhangzhiwang
 * @date 2017年6月21日 下午10:39:20
 */
public class TestSpring {

	@Test
	public void test() {
		//方式一：通过全局配置文件生成bean工厂（IOC容器）
		Resource resource = new ClassPathResource("applicationContext_zzw.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		//通过bean工厂生产bean
		User user = (User) beanFactory.getBean("user1");
		System.out.println(user);
		
		//方式二：
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_zzw.xml");
		User user2 = (User) applicationContext.getBean("user1");
		System.out.println(user2);
	}

}

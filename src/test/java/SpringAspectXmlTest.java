import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.dao.IUserDao;

/**
 * 用xml配置的方式实现aop测试
 *
 * @author zhangzhiwang
 * @date 2017年7月16日 下午3:53:34
 */
public class SpringAspectXmlTest {
	@Test
	public void test() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_zzw.xml");
		IUserDao userDao = (IUserDao) applicationContext.getBean("userDaoImpl");
		userDao.save(null);
	}
}

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.proxy.practice.IChannelDao;

/**
 * 面向切面编程测试
 *
 * @author zhangzhiwang
 * @date 2017年7月15日 下午10:38:04
 */
public class AopTest {
	@Test
	public void testAop() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext_zzw.xml");
		IChannelDao channelDao = (IChannelDao) applicationContext.getBean("channelDaoProxy");
		channelDao.save();
	}
}

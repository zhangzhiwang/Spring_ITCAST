package com.asiainfo.proxy.practice;

/**
 * 动态代理测试
 *
 * @author zhangzhiwang
 * @date 2017年7月12日 下午9:37:02
 */
public class DynamicProxyTest {
	public static void main(String[] args) {
		IChannelDao proxyDao = (IChannelDao) new DynamicProxy(new ChannelDaoImpl()).getProxyInstance();
		proxyDao.save();
	}
}

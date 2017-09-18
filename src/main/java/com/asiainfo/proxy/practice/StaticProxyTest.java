package com.asiainfo.proxy.practice;

/**
 * 静态代理测试
 *
 * @author zhangzhiwang
 * @date 2017年7月12日 下午9:25:50
 */
public class StaticProxyTest {
	public static void main(String[] args) {
		IChannelDao proxyDao = new StaticProxy(new ChannelDaoImpl());
		proxyDao.save();
	}
}

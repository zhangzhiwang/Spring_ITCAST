package com.asiainfo.proxy.practice;

/**
 * 静态代理</br>
 * 优点：</br>
 * 符合开闭原则，在不需要修改目标对象方法的基础上对功能进行扩展
 * 缺点：</br>
 * 1、由于静态代理类要实现至少一个特定的接口，所以如果接口很多的话会写很多代理类</br>
 * 2、由于静态代理类要实现至少一个特定的接口，接口发生变化，代理类需要做出相应的修改
 *
 * @author zhangzhiwang
 * @date 2017年7月12日 下午9:19:53
 */
public class StaticProxy implements IChannelDao {
	private ChannelDaoImpl target;

	public StaticProxy() {
		super();
	}

	public StaticProxy(ChannelDaoImpl target) {
		super();
		this.target = target;
	}

	public ChannelDaoImpl getTarget() {
		return target;
	}

	public void setTarget(ChannelDaoImpl target) {
		this.target = target;
	}

	public void save() {
		System.out.println("静态代理开启事务...");
		target.save();
		System.out.println("静态代理提交事务。");
	}

}

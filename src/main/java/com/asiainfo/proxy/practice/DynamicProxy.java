package com.asiainfo.proxy.practice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理</br>
 * 优点：</br>
 * 解决了静态代理的不足：不需要实现接口，目标对象的接口发生变化代理类不需要作出变动</br>
 * 缺点：</br>
 * 目标对象必须实现接口
 *
 * @author zhangzhiwang
 * @date 2017年7月12日 下午9:31:35
 */
public class DynamicProxy {
	private Object target;

	public DynamicProxy(Object target) {
		super();
		this.target = target;
	}

	public DynamicProxy() {
		super();
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Object getProxyInstance() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {// 代理方法

			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("动态代理开启事务...");
				Object returnValue = method.invoke(target, args);// 执行目标对象的方法，返回值为目标对象的返回值，如果目标对象执行的方法没有返回值类型，则返回void
				System.out.println("动态代理提交事务。");
				return returnValue;
			}
		});
	}
}

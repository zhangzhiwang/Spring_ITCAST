package com.asiainfo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.asiainfo.dao.impl.UserDaoImpl;

/**
 * 动态代理</br>
 * 步骤：</br>
 * 1、动态代理类不用实现目标对象所实现的接口</br>
 * 2、动态代理类也要包含目标对象属性</br>
 * 3、使用Proxy.newProxyInstance获得代理对象</br>
 * </br>
 * 优点：</br>
 * 1、不需要继承目标对象所实现的特定接口，使用范围更为广泛</br>
 * 2、目标对象所实现的接口发生变化时，代理类不需要做出变动</br>
 * </br>
 * 缺点：</br>
 * 目标对象必须至少实现一个接口
 *
 * @author zhangzhiwang
 * @date 2017年7月2日 下午3:05:57
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

	public Object getProxyInstance() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {

			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if ("save".equals(method.getName())) {
					System.out.println("动态代理开启事务");
				}

				Object returnValue = method.invoke(target, args);

				if ("save".equals(method.getName())) {
					System.out.println("动态代理结束事务");
				}
				return returnValue;
			}
		});
	}
}

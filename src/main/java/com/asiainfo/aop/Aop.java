package com.asiainfo.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * 动态代理的方式实现AOP
 *
 * @author zhangzhiwang
 * @date 2017年7月3日 下午2:00:05
 */
@Component
public class Aop {
	/** 目标对象 */
	private Object target;
	@Resource(name = "aspect")
	private Aspect aspect;

	public Aop(Object target) {
		super();
		this.target = target;
	}

	public Aop() {
		super();
	}

	public Object getProxyInstance() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {

			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				aspect.before();
				Object returnValue = method.invoke(target, args);
				aspect.after();
				return returnValue;
			}

		});
	}

}

package com.asiainfo.proxy.practice;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 面向切面变成
 *
 * @author zhangzhiwang
 * @date 2017年7月15日 下午10:17:19
 */
//@Component("aopTest")
public class Aop implements MethodInterceptor {
	private static Object target;
	private static Aspect aspect;

	public static Object getProxyInstance(Object obj, Aspect aspectParam) {
		// 参数校验略
		target = obj;
		aspect = aspectParam;
		// 工具类
		Enhancer enhancer = new Enhancer();
		// 设置父类
		enhancer.setSuperclass(obj.getClass());
		// 设置回调方法
		enhancer.setCallback(new Aop());
		// 创建代理对象
		return enhancer.create();
	}

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		// 执行切面方法
		aspect.before();

		// 执行目标方法
		Object returnValue = method.invoke(target, args);

		// 执行切面方法
		aspect.after();
		return returnValue;
	}
}

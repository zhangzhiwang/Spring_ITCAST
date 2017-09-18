package com.asiainfo.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * cglib代理（子类代理）——动态生成未实现任何接口的类的子类</br>
 * 步骤：</br>
 * 1、cglib代理类要不汗目标对象属性</br>
 * 2、cglib代理类实现MethodInterceptor接口</br>
 * 3、增加获取代理对象的方法</br>
 * （1）新建Enhancer对象</br>
 * （2）设置目标对象的父类类型</br>
 * （3）设置毁掉方法：enhancer.setCallback(this);</br>
 * （4）生成代理对象</br>
 * </br>
 * 三种代理方法的总结：</br>
 * 1、目标对象所在类实现了接口，用动态代理生成代理对象</br>
 * 2、目标对象所在类没有实现接口，用cglib代理生成代理类</br>
 * 3、由于cglib代理时子类代理，那么根据继承的特性，final类不能用cglib代理，否则跑异常；目标对象类的final方法不能被代理，否则执行代理对象的该方法时实际上执行的时目标对象的方法而非代理对象的方法
 *
 * @author zhangzhiwang
 * @date 2017年7月2日 下午9:53:03
 */
public class CglibProxy implements MethodInterceptor {
	/** 目标对象 */
	private Object target;

	public CglibProxy() {
		super();
	}

	public CglibProxy(Object target) {
		super();
		this.target = target;
	}

	public Object getProxyInstance() {
		// 工具类
		Enhancer enhancer = new Enhancer();
		// 设置父类
		enhancer.setSuperclass(target.getClass());
		// 设置回调方法
		enhancer.setCallback(this);
		// 生成代理对象
		return enhancer.create();
	}

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy mp) throws Throwable {
		System.out.println("cglib开启事务");
		Object objReturn = method.invoke(target, args);
		System.out.println("cglib关闭事务");
		return objReturn;
	}
	
}

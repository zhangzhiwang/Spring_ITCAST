package com.asiainfo.proxy.practice;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * cglib代理测试</br>
 * 继承的特性：</br>
 * 1、final类不能被继承</br>
 * 2、final方法不能被重写</br>
 * 3、static方法不能被重写</br>
 * </br>
 * cglib代理的限制：</br>
 * 1、final类不能被代理</br>
 * 2、final方法不能被代理</br>
 * 3、static方法不能被代理 </br>
 * </br>
 * 用cglib代理时目标对象所在类也可以实现接口
 *
 * @author zhangzhiwang
 * @date 2017年7月15日 下午5:18:31
 */
public class CglibProxyTest implements MethodInterceptor {
	private Object target;

	public CglibProxyTest() {
		super();
	}

	public CglibProxyTest(Object target) {
		super();
		this.target = target;
	}

	public static void main(String[] args) {
		// A a = new Aa();
		// a.meth1();

		A a = (A) new CglibProxyTest(new A()).getProxyInstance();
		a.meth1();
		a.meth2();
		a.meth3();

		a.func1();
	}

	public Object getProxyInstance() {
		// 设置工具类
		Enhancer enhancer = new Enhancer();
		// 设置父类
		enhancer.setSuperclass(target.getClass());
		// 设置回调函数
		enhancer.setCallback(this);
		// 创建子类对象
		return enhancer.create();
	}

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("cglib代理开启事物...");
		Object returnValue = method.invoke(target, args);
		System.out.println("cglib代理提交事物...");
		return returnValue;
	}

}

class A implements B {
	public static void meth1() {
		System.out.println("A.meth1()");
	}

	public final void meth2() {
		System.out.println("A.meth2()");
	}

	public void meth3() {
		System.out.println("A.meth3()");
	}

	public void func1() {
		System.out.println("A.func1()");
	}
}

class Aa extends A {
	// @Override
	public static void meth1() {
		System.out.println("Aa.meth1()");
	}
}

interface B {
	void func1();
}
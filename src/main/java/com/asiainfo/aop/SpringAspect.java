package com.asiainfo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * spring的切面</br>
 * 关注点代码（大量重复的代码）形成的类叫切面
 * 
 * @author zhangzhiwang
 * @date 2017年7月16日 下午12:30:14
 */
@Component   //声明该类为spring bean
@Aspect      //声明该类为切面
public class SpringAspect {
	
	@Pointcut("execution(* com.asiainfo.dao.impl.UserDaoImpl.save())")   //切点表达式：execution()为固定写法，括号里面第一个*表示任意返回值，后面是某包下面的某个类（所有类可以写成*）的某个方法（所有方法可以写成*），方法后面的(..)表示任意参数
																		   //spring会根据切点表达式进行方法的拦截
//	@Pointcut("execution(protected * com.asiainfo.dao.impl.UserDaoImpl.*(..))")   //拦截com.asiainfo.dao.impl.UserDaoImpl下面的所有修饰符为protected的方法
//	@Pointcut("execution(* com..*.*(..))")  //拦截com包及其子包下所有类的所有方法
//	@Pointcut("execution(* com.asiainfo.dao.impl.UserDaoImpl.queryById(..)) or execution(* com.asiainfo.dao.impl.OrderDaoImpl.insertOrder())")  //拦截UserDaoImpl下面的queryById()方法或者OrderDaoImpl下面的insertOrder()方法，其中“||”可以写成“or”。注：没有“与”逻辑，因为没有任何一个方法既属于这个类又属于那个类
//	@Pointcut(" not execution(* com.asiainfo.dao.impl.UserDaoImpl.*(..))")   //“非”逻辑语法“!”或“ not”在spring 4测试不通过
	public void diyName() {}
	
	@Before("diyName()")   //@Before 前置通知，表示在执行目标方法的前面执行此方法，后面的参数表示使用指定方法上面的切点表达式
	public void startTransaction() {
		System.out.println("开启事务...");
	}
	
	@After("diyName()")    //@After  后置通知，表示在执行目标方法的后面执行此方法，后面的参数表示使用指定方法上面的切点表达式
//	@After("execution(* com.asiainfo.dao.impl.UserDaoImpl.queryById(..))")
	public void commitTransaction() {
		System.out.println("提交事务。");
	}
	
	@AfterReturning("diyName()")   //@AfterReturning   返回后通知，当目标方法执行后执行此方法，与@After不同的是@AfterReturning在目标方法抛出异常后该方法不执行，而@After方法无论目标方法是否抛出异常都执行
	public void afterReturning() {
		System.out.println("afterReturning...");
	}
	
	@AfterThrowing("diyName()")   //@AfterThrowing    抛异常后通知，在目标方法抛出异常后执行此方法
	public void afterThrowing() {
		System.out.println("afterThrowing...");
	}
	
	@Around("diyName()")         //@Around    环绕通知，环绕目标方法的前后，相当于@Before + @After
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("目标方法执行前执行...");
		//执行目标方法
		proceedingJoinPoint.proceed();
		System.out.println("目标方法执行后执行...");
	}
}

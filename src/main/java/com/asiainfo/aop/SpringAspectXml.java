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
 * 用xml配置的方式实现aop</br>
 * 关注点代码（大量重复的代码）形成的类叫切面
 * 
 * @author zhangzhiwang
 * @date 2017年7月16日 下午12:30:14
 */
public class SpringAspectXml {

	public void startTransaction() {
		System.out.println("开启事务...");
	}

	public void commitTransaction() {
		System.out.println("提交事务。");
	}

	public void afterReturning() {
		System.out.println("afterReturning...");
	}

	public void afterThrowing() {
		System.out.println("afterThrowing...");
	}

	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("目标方法执行前执行...");
		// 执行目标方法
		proceedingJoinPoint.proceed();
		System.out.println("目标方法执行后执行...");
	}
}

package com.asiainfo.aop;

import org.springframework.stereotype.Component;

/**
 * 切面
 *
 * @author zhangzhiwang
 * @date 2017年7月2日 下午10:57:28
 */
@Component
public class Aspect {
	public void before() {
		System.out.println("AOP开启事务");
	}

	public void after() {
		System.out.println("AOP关闭事务");
	}

}

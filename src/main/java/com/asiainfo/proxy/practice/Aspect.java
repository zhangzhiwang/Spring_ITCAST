package com.asiainfo.proxy.practice;

import org.springframework.stereotype.Component;

/**
 * 切面
 *
 * @author zhangzhiwang
 * @date 2017年7月15日 下午10:13:34
 */
@Component("aspectTest")
public class Aspect {
	public void before() {
		System.out.println("before");
	}
	
	public void after() {
		System.out.println("after");
	}
}

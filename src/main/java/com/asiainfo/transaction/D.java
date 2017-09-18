package com.asiainfo.transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
//@Transactional   //在父类的上面使用@Transactional在spring 4上测试未通过
public class D {
	public void met1() {
		System.out.println("D.met1()");
	}
}

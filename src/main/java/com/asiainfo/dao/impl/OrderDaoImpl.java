package com.asiainfo.dao.impl;

import org.springframework.stereotype.Component;

@Component
public class OrderDaoImpl {
	public void insertOrder() {
		System.out.println("插入订单到数据库");
	}
	
	public void delete() {
		System.out.println("删除订单数据");
	}
}

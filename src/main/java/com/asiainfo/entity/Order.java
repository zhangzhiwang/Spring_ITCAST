package com.asiainfo.entity;

/**
 * 订单
 *
 * @author zhangzhiwang
 * @date 2017年6月23日 下午10:20:36
 */
public class Order {
	/** 订单id */
	private int id;
	/** 订单号 */
	private String orderNumber;

	public Order() {
		System.out.println("创建Order对象");
	}

	public void initOrder() {
		System.out.println("初始化Order");
	}

	public void destroyOrder() {
		System.out.println("销毁Order");
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + "]";
	}

}

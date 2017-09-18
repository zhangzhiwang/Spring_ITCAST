package com.asiainfo.entity;

/**
 * 用户
 *
 * @author zhangzhiwang
 * @date 2017年6月21日 下午10:37:00
 */
public class User {
	/** 用户id */
	private int id;
	/** 用户姓名 */
	private String name;
	private Order order;

	public User() {
		System.out.println("创建User对象，无参构造方法");
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		System.out.println("有参构造方法");
	}

//	public User(int id, String name, Order orderZzw123) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.order = orderZzw123;
//	}

	public void setIdZzw(int id) {
		this.id = id;
	}
	
//	public int getId() {
//		return id;
//	}

	public void setId(int id) {
		this.id = id;
	}

//	public String getName() {
//		return name;
//	}

	public void setName(String name) {
		this.name = name;
	}

//	public Order getOrder() {
//		return order;
//	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void initUser() {
		System.out.println("初始化user");
	}

	public void destroyUser() {
		System.out.println("销毁user");
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", order=" + order + "]";
	}

}

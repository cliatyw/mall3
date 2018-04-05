package com.test.mall3.order.service;

public class Order {
	private int member_no;
	private int item_no;
	private String order_date;
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getItem_no() {
		return item_no;
	}
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	@Override
	public String toString() {
		return "Order [member_no=" + member_no + ", item_no=" + item_no + ", order_date=" + order_date + "]";
	}
}

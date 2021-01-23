package com.foodplaza.pojo;

public class Order_1 
{
	int order_id;
	String email_id,food_name;
	int quantity;
	double total_price;
	String date;
	
	public Order_1() {
		super();
	}

	public Order_1(String email_id) {
		super();
		this.email_id = email_id;
	}
	
	public Order_1(int order_id, String email_id, double total_price, String date) {
		super();
		this.order_id = order_id;
		this.email_id = email_id;
		this.total_price = total_price;
		this.date = date;
	}

	public Order_1(String email_id, String food_name, int quantity, double total_price, String date) {
		super();
		this.email_id = email_id;
		this.food_name = food_name;
		this.quantity = quantity;
		this.total_price = total_price;
		this.date = date;
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Order_1 [order_id=" + order_id + ", email_id=" + email_id + ", food_name=" + food_name + ", quantity="
				+ quantity + ", total_price=" + total_price + ", date=" + date + "]";
	}
	
}

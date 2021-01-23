package com.foodplaza.pojo;

public class Cart 
{
	int cart_id;
	String cust_emailid;
	int food_id;
	String food_name;
	int cart_quantity;
	double total_price;

	public Cart() 
	{
		super();
	}

	public Cart(String cust_emailid, int food_id, String food_name, int cart_quantity, double total_price) {
		super();
		this.cust_emailid = cust_emailid;
		this.food_id = food_id;
		this.food_name = food_name;
		this.cart_quantity = cart_quantity;
		this.total_price = total_price;
	}

	public Cart(int cart_id, String cust_emailid, int food_id, String food_name, int cart_quantity,
			double total_price) 
	{
		super();
		this.cart_id = cart_id;
		this.cust_emailid = cust_emailid;
		this.food_id = food_id;
		this.food_name = food_name;
		this.cart_quantity = cart_quantity;
		this.total_price = total_price;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public String getCust_emailid() {
		return cust_emailid;
	}

	public void setCust_emailid(String cust_emailid) {
		this.cust_emailid = cust_emailid;
	}

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public int getCart_quantity() {
		return cart_quantity;
	}

	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	@Override
	public String toString() 
	{
		return "Cart [cart_id=" + cart_id + ", cust_emailid=" + cust_emailid + ", food_id=" + food_id + ", food_name="
				+ food_name + ", cart_quantity=" + cart_quantity + ", total_price=" + total_price + "]";
	}

}

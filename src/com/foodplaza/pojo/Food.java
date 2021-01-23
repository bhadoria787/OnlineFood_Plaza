package com.foodplaza.pojo;

public class Food {
	int food_id;
	String food_name, food_type, food_category;
	int price;

	public Food() 
	{
		super();
	}

	public Food(int food_id, String food_name, String food_type, String food_category, int price) 
	{
		super();
		this.food_id = food_id;
		this.food_name = food_name;
		this.food_type = food_type;
		this.food_category = food_category;
		this.price = price;
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

	public String getFood_type() {
		return food_type;
	}

	public void setFood_type(String food_type) {
		this.food_type = food_type;
	}

	public String getFood_category() {
		return food_category;
	}

	public void setFood_category(String food_category) {
		this.food_category = food_category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() 
	{
		return "Food [food_id=" + food_id + ", food_name=" + food_name + ", food_type=" + food_type + ", food_category="
				+ food_category + ", price=" + price + "]";
	}

}

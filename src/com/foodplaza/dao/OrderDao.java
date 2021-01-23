package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Order_1;

public interface OrderDao 
{
	 boolean placeOrder(Order_1 o);
	
	 List<Order_1> showOrder();
	

}

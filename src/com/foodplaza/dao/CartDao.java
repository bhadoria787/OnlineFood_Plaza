package com.foodplaza.dao;

import java.util.List;
import com.foodplaza.pojo.Cart;

public interface CartDao 
{
	int addCart(Cart cart);

	List<Cart> showCart(String cust_emailId);

	int deleteCart(int cartId);

	int clearCart(String cust_emailId);

}

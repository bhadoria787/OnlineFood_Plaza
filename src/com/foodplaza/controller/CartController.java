package com.foodplaza.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.foodplaza.dao.CartDaoImpl;
import com.foodplaza.dao.FoodDaoImpl;
import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Food;


@Controller
public class CartController {
	// Add to Cart\n2.Show Cart\n3.Delete Cart\n4.Clear cart
	@Autowired
	CartDaoImpl cartimpl;
	@Autowired
	FoodDaoImpl fdi;
	

	@RequestMapping(value = "/cartForm", method = RequestMethod.GET)
	public ModelAndView customerForm() {

		return new ModelAndView("AddCart", "command", new Cart());
	}


	@RequestMapping(value = "/addtocart", method = RequestMethod.GET)
	public ModelAndView addCart(int foodId, HttpSession session) {
		Food food = fdi.searchFoodById(foodId);
		String customeremailId = (String) session.getAttribute("user");
		int Quantity = 1;
		double totalPrice = food.getPrice() * Quantity;

		Cart cart = new Cart(customeremailId, food.getFood_id(), food.getFood_name(), Quantity, totalPrice);
		cartimpl.addCart(cart);
		return new ModelAndView("redirect:/showcart");
	}

	
	@RequestMapping(value = "/showcart", method = RequestMethod.GET)
	public ModelAndView showcart(HttpSession session) {
		String emailId = (String) session.getAttribute("user");
		List<Cart> clist = cartimpl.showCart(emailId);
		return new ModelAndView("CartList", "cartlist", clist);
	}

	
	@RequestMapping(value = "/deleteCart", method = RequestMethod.GET)
	public ModelAndView deletecart(int cartId) {
		cartimpl.deleteCart(cartId);
		return new ModelAndView("CartList","deletecart","Item removes from your cart list");
	}

	
	@RequestMapping(value = "/clearCart", method = RequestMethod.GET)
	public ModelAndView clearcart(String cust_emailId) {
		cartimpl.clearCart(cust_emailId);
		return new ModelAndView("CartList","deletecart","Item cleared from your cart list");
	}

}

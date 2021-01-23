package com.foodplaza.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodplaza.dao.AdminDaoImpl;
import com.foodplaza.dao.CartDaoImpl;
import com.foodplaza.dao.FoodDaoImpl;
import com.foodplaza.dao.OrderDaoImpl;
import com.foodplaza.pojo.Admin;
import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Order_1;
import com.mail.SendMailSSL;

@Controller
public class OrderController {
	
	@Autowired
	CartDaoImpl cartimpl;
	@Autowired
	FoodDaoImpl fdi;
	@Autowired
	OrderDaoImpl odi;
	@Autowired
	AdminDaoImpl adi;
	
	@RequestMapping(value = "/placeorder")
	public ModelAndView placeOrder(HttpServletRequest req, HttpSession session) 
	{

		double totalprice = 0;
		
		String custname = (String) session.getAttribute("user");
		List<Cart> clist = cartimpl.showCart(custname);
		if (clist.size()<=0) //if cart is empty
		{
			return new ModelAndView("CartList","pofail","Your cart is empty..Add item to place order");
		}
		String Food_name[] = req.getParameterValues("foodname");
		String price[] = req.getParameterValues("price");
		String quantity[] = req.getParameterValues("quantity");

		for (int i = 0; i < price.length; i++) 
		{
			totalprice = totalprice + (Double.parseDouble(price[i]) * Integer.parseInt(quantity[i]));
		}

		req.setAttribute("Total", "totalprice");
		String date = new SimpleDateFormat("dd/MM/yyyy hh.mm aa").format(new Date()).toString();
		Order_1 o = new Order_1();
		o.setEmail_id(custname);
		o.setTotal_price(totalprice);
		o.setDate(date);
		
		boolean status = odi.placeOrder(o);
		if (status)
		{
			Admin ad=adi.getAdmin();
			String from=ad.getAdmin_emailid(),password=ad.getAdmin_pass(),
					to=custname, 
					subject="food ordered from FOODPLAZA",
					msg="Your order placed successfully \n"
						+"Thanks for visiting and ordering your meal from FOODPLAZA\n"
						+"your food will reach to you within a hour\n"
						+ "we will love to get feedback from you";
			try {
			SendMailSSL.send(from, password, to, subject, msg);
			}
			catch(Exception e) 
			{
				for (int i = 0; i < price.length; i++) //
				{
					Order_1 orderhist = new Order_1();
					orderhist.setEmail_id(custname);
					orderhist.setFood_name(Food_name[i]);
					orderhist.setQuantity(Integer.parseInt(quantity[i]));
					orderhist.setTotal_price(Double.parseDouble(price[i]));
					orderhist.setDate(date);
					System.out.println(odi.custOrderhistory(orderhist));
					
				}
				cartimpl.clearCart(custname);
				String str="order placed successfully and your total bill is "+totalprice+"RS";
				return new ModelAndView("CartList","emailnotsent",str);
			}
			for (int i = 0; i < price.length; i++) //
			{
				Order_1 orderhist = new Order_1();
				orderhist.setEmail_id(custname);
				orderhist.setFood_name(Food_name[i]);
				orderhist.setQuantity(Integer.parseInt(quantity[i]));
				orderhist.setTotal_price(Double.parseDouble(price[i]));
				orderhist.setDate(date);
				odi.custOrderhistory(orderhist);
				
			}
			cartimpl.clearCart(custname);
			String str="order placed placed successfully and your total bill is "+totalprice+"RS";
			return new ModelAndView("CartList","emailsent",str);

		}
		else
		{
			//cartimpl.clearCart(s);
			return new ModelAndView("CartList","pofail","Fail to place order, Please try again");
		}
			
	}
	
	@RequestMapping(value = "/orderhistory" ,method = RequestMethod.GET)
	public ModelAndView customerorderhistory(HttpSession session) {
		String user=(String)session.getAttribute("user");
		List<Order_1> orderlist=odi.Orderhistory(user);
		if(orderlist.size()<=0)
		{return new ModelAndView("OrderHistory","emptyHistory","You  don't have any purchase history");}
		return new ModelAndView("OrderHistory","orderHistory",orderlist);
	}

	@RequestMapping(value = "/deletecustorderhistory" ,method = RequestMethod.GET)
	public ModelAndView deleteCustorderhistory(HttpSession session) {
		String user=(String)session.getAttribute("user");
		odi.deleteCustOrderhistory(user);
		return new ModelAndView("OrderHistory","orderHistorydeleted","Your purchasing history is cleared ");
	}
}

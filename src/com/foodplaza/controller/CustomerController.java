package com.foodplaza.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.foodplaza.dao.CustomerDaoImpl;
import com.foodplaza.dao.OrderDaoImpl;
import com.foodplaza.pojo.Customer;


@Controller
public class CustomerController 
{
	@Autowired
	CustomerDaoImpl cdi;
	
	@Autowired
	OrderDaoImpl odi;

	@RequestMapping(value = "/customerform", method = RequestMethod.GET)
	public ModelAndView customerForm() 
	{
		return new ModelAndView("AddCustomer", "command", new Customer());
	}

	@RequestMapping(value = "/savecustomer", method = RequestMethod.POST)
	public ModelAndView Addcustomer(@ModelAttribute("cust") Customer cust) 
	{
		cdi.addCustomer(cust);
		return new ModelAndView("index","regissuc","Successfully Registered!!! \nLogin to order your favourite meal");
	}
	
	@RequestMapping(value = "/updatecustomerform", method = RequestMethod.GET)
	public ModelAndView updatecustomerForm() 
	{
		return new ModelAndView("UpdateCustomer", "command", new Customer());
	}

	@RequestMapping(value = "/updatecustomer", method = RequestMethod.POST)
	public ModelAndView updatecustomer(@ModelAttribute("cust") Customer cust) 
	{
		cdi.updateCustomer(cust);
		return new ModelAndView("index","custdetailupdate","your profile is updated successfully!!!");
	}
	
	
	@RequestMapping(value = "/customerlist" ,method = RequestMethod.GET)
	public ModelAndView getCustomerList() {
		List<Customer> clist=cdi.getAllCustomer();
		return new ModelAndView("CustomerList","custlist",clist);
	}
	
	@RequestMapping(value = "/editCustomer",method = RequestMethod.GET)
	public ModelAndView editCustomer(String custEmail) {
		Customer c=cdi.searchCustomerByEmailId(custEmail);
		return new ModelAndView("UpdateCustomer","command",c);
	}
	
	@RequestMapping(value = "/deleteCustomer",method = RequestMethod.GET)
	public ModelAndView deleteCust(String custEmail) {
		cdi.deleteCustomer(custEmail);
		List<Customer> clist=cdi.getAllCustomer();
		return new ModelAndView("CustomerList","custlist",clist);
	}
	
}

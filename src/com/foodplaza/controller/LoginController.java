package com.foodplaza.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.foodplaza.dao.AdminDaoImpl;
import com.foodplaza.dao.CustomerDaoImpl;
import com.foodplaza.dao.LoginDaoImpl;
import com.foodplaza.pojo.Admin;
import com.foodplaza.pojo.Customer;

@Controller
public class LoginController {

	@Autowired
	LoginDaoImpl ldi;

	@Autowired
	CustomerDaoImpl cdi;
	
	@Autowired
	AdminDaoImpl adi;

	/** VIEW USER LOGIN FORM **/ // from here to jsp
	@RequestMapping("loginform")
	public String getLoginPage() 
	{
		return "Login";
	}

	/** USER LOGIN **/ // from jsp to here

	@RequestMapping(value = "/savelogin", method = RequestMethod.POST)
	public ModelAndView Login(HttpServletRequest req, HttpSession session) 
	{
		String type = req.getParameter("type");
		String username = req.getParameter("emailid");
		String pass = req.getParameter("pass");

		if (type.equals("USER")) 
		{
		
			if(ldi.userlogin(username, pass))
			{
				session.setAttribute("user", username);
				String name=cdi.searchCustomerByEmailId(username).getCust_name();
				session.setAttribute("customer_name", name);
				return new ModelAndView("index","loginsuc","userloginsuc");
			} 
			else 
			{
				return new ModelAndView("Login","loginfail","Oops!! "+username+" you have enter invalid detail\n try again");
			}
		}
		if (type.equals("ADMIN")) 
		{
			if(ldi.adminLogin(username, pass))
			{
				session.setAttribute("admin", username);
				String adminname=adi.getAdmin().getAdmin_name();
				session.setAttribute("admin_name", adminname);
				return new ModelAndView("index","loginsuc","adminloginsuc");
			} 
			else 
			{
				return new ModelAndView("Login","loginfail","Oops!! "+username+" you have enter invalid detail\n try again");
			}	
		}
		return new ModelAndView("Login");
	}
	
	
	
	
	@RequestMapping(value = "/forgotpasswordform")
	public ModelAndView forgotpasswordForm() 
	{
		return new ModelAndView("Forgotpassword");
	}
	
	
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public ModelAndView forgotpassword(HttpServletRequest req) 
	{
		String type = req.getParameter("type");
		String phoneno=req.getParameter("phoneno");
		String emailid=req.getParameter("emailid");
		
		if (type.equals("USER")) 
		{
		try {
		Customer c=cdi.searchCustomerByEmailId(emailid);
		String PhoneNum=c.getCust_contact();
		if(PhoneNum.equals(phoneno))
		{
			return new ModelAndView("Forgotpassword", "passresetsuccess","Your password is "+c.getCust_pass());
		}
		}
		catch(Exception e)
		{
			return new ModelAndView("Forgotpassword", "usernotpresent","There is no such user with this ID..Please enter vaild ID ");
		}
		
		return new ModelAndView("Forgotpassword", "wrongno","incorrect phone number...try again  with correct one");
		}
		
		if (type.equals("ADMIN")) 
		{
			try {
				Admin a=adi.searchAdminByEmailId(emailid);
				String PhoneNum=a.getAdmin_phone_no();
				if(PhoneNum.equals(phoneno))
				{
					return new ModelAndView("Forgotpassword", "passresetsuccess","Your password is "+a.getAdmin_pass());
				}
				}
				catch(Exception e)
				{
					return new ModelAndView("Forgotpassword", "usernotpresent","There is no such user with this ID..Please enter vaild ID ");
				}
				
				return new ModelAndView("Forgotpassword", "wrongno","incorrect phone number...try again  with correct one");
				}
		
		return new ModelAndView("Forgotpassword");
		}

	
	

	@RequestMapping(value = "/changepassform", method = RequestMethod.GET)
	public String ChangeUserPassForm() 
	{
		return "ChangePassword";
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public ModelAndView ChangeUserPassword(HttpServletRequest req, HttpSession session) 
	{
		String type = req.getParameter("type");
		
		String newpass = req.getParameter("new_pass");

		if (type.equals("USER")) {
			String customeremailId = (String) session.getAttribute("user");
			boolean b = ldi.userchangePass(customeremailId, newpass);
			if (b) 
			{
				return new ModelAndView("index","changepassuc",customeremailId+" your password  changed sucessfully");
			} 
			else 
			{
				return new ModelAndView("ChangePassword","changepassfail","Oops!! "+customeremailId+" failed to change password\n Try angain");
			}
		}

		if (type.equals("ADMIN")) 
		{
			String adninemailId = (String) session.getAttribute("admin");
			boolean b = ldi.adminChangePass(adninemailId, newpass);
			if (b) 
			{
				return new ModelAndView("index","changepassuc",adninemailId+" your password changed sucessfully");
			} else 
			{
				return new ModelAndView("ChangePassword","changepassfail","Oops!! "+adninemailId+" failed to change password\n Try angain");
			}
		}
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/updateadminform", method = RequestMethod.GET)
	public ModelAndView updateadminForm() 
	{
		return new ModelAndView("UpdateAdmin", "command", new Admin());
	}
	
	
	@RequestMapping(value = "/updateadmin", method = RequestMethod.POST)
	public ModelAndView updateadmin(HttpServletRequest r) 
	{
		Admin a=new Admin();
		a.setAdmin_name(r.getParameter("admin_name"));
		a.setAdmin_emailid(r.getParameter("admin_emailid"));
		a.setAdmin_pass(r.getParameter("admin_pass"));
		a.setAdmin_phone_no(r.getParameter("admin_phone_no"));
		
		System.out.println(adi.updateAdmin(a));
		return new ModelAndView("index","detailupdate","your profile is updated successfully!!!");
	}
	
	
	
	@RequestMapping( value = "/logout")
	public ModelAndView Logout(HttpSession session,HttpServletRequest req)
	{
			session=req.getSession();
			session.invalidate();
		
		return new ModelAndView("index","LOGOUT","signout");
	}
}

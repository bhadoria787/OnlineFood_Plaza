package com.foodplaza.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodplaza.dao.FeedbackDaoImpl;
import com.foodplaza.pojo.Feedback;

@Controller
public class FeedbackController {
	
	@Autowired
	FeedbackDaoImpl fdi;
	
	@RequestMapping(value = "/feedbackform",method = RequestMethod.GET)
	public ModelAndView feedbackform()
	{
		return new ModelAndView("addfeedback","command",new Feedback());
	}
	
	@RequestMapping(value = "/addFeedback",method = RequestMethod.POST)
	public ModelAndView Addfeedback(@ModelAttribute("feedback") Feedback feedback)
	{
		fdi.addFeedback(feedback);
		String msg="We will see to it and try to give our best service";
		return new ModelAndView("index","custfeedback",msg);
	}
	
	@RequestMapping(value = "/showfeedbacklist" ,method = RequestMethod.GET)
	public ModelAndView ShowFeedbacks(HttpSession session) 
	{
		String emailId=(String)session.getAttribute("user");
		List<Feedback> fblist=fdi.getFeedback(emailId);
		return new ModelAndView("FeedBackList","feedbklist",fblist);
	}
	
	@RequestMapping(value = "/showAllfeedback" ,method = RequestMethod.GET)
	public ModelAndView ShowAllFeedbacks() {
		List<Feedback> fblist=fdi.getAllFeedback();
		return new ModelAndView("FeedBackList","feedbklist",fblist);
	}
	
	@RequestMapping(value = "/deletefd" ,method = RequestMethod.GET)
	public ModelAndView removeFeeback(int feedbackid) {
		fdi.RemoveFeedback(feedbackid);
		List<Feedback> fblist=fdi.getAllFeedback();
		return new ModelAndView("FeedBackList","feedbklist",fblist);
	} 

}

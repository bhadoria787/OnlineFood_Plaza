package com.foodplaza.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.foodplaza.dao.FoodDaoImpl;
import com.foodplaza.pojo.Food;

@Controller
public class FoodController {
	@Autowired
	FoodDaoImpl fdi;


	@RequestMapping(value = "/showFoodForm", method = RequestMethod.GET)
	public ModelAndView showFoodForm()//
	{
		return new ModelAndView("AddFood", "command", new Food());//
	}

	@RequestMapping(value = "/savefood", method = RequestMethod.POST)
	public ModelAndView saveFood(@ModelAttribute("food") Food food) {
		fdi.addFood(food);
		return new ModelAndView();
	}

	@RequestMapping(value = "/foodupdateform", method = RequestMethod.GET)
	public ModelAndView showFoodupdateForm() {
		
		return new ModelAndView("UpdateFood", "command", new Food());
	}

	@RequestMapping(value = "/updatefood", method = RequestMethod.POST)
	public ModelAndView updateFood(@ModelAttribute("Food") Food food) {
		fdi.updateFood(food);
		return new ModelAndView("redirect:/showcartlist");
	}

	@RequestMapping(value = "/showcartlist", method = RequestMethod.GET)
	public ModelAndView getfood() {
		List<Food> flist = fdi.getAllFood();
		if (flist.size() <=0 )
			return new ModelAndView("SearchFood", "searchfail", "Sorry.. food not available");
		else
			return new ModelAndView("FoodList", "foodlist", flist);
	}

	@RequestMapping(value = "/Searchfoodform", method = RequestMethod.GET)
	public String getfoodform() {

		return "SearchFood";
	}

	@RequestMapping(value = "/searchfood", method = RequestMethod.POST)
	public ModelAndView getfoodByname(HttpServletRequest req) 
	{

		String searchby = req.getParameter("Searchby");
		if (searchby.equals("Name")) {
			String food_name = req.getParameter("foodname");

			List<Food> flist = fdi.searchFoodByName(food_name);
			if (flist.size() <=0 )
				return new ModelAndView("SearchFood", "searchfail", "Sorry "+food_name+" is not available");
			else
				return new ModelAndView("FoodList", "foodlist", flist);

		}

		else if (searchby.equals("category")) 
		{
			String food_category = req.getParameter("foodcategory");
			List<Food> flist = fdi.searchFoodBycategory(food_category);
			if (flist.size() <=0)
				return new ModelAndView("SearchFood", "searchfail", "Sorry "+food_category+" is not available");
			else
				return new ModelAndView("FoodList", "foodlist", flist);

		}

		return new ModelAndView("Fail", "status", "Sorry food is not available");
	}

	@RequestMapping(value = "/editFood", method = RequestMethod.GET)
	public ModelAndView searchyById(int foodId) {
		Food fd = fdi.searchFoodById(foodId);
		return new ModelAndView("UpdateFood", "command",fd );
	}	

	@RequestMapping(value = "/deleteFood", method = RequestMethod.GET)
	public ModelAndView deleteFood(int foodId) {
		fdi.deleteFood(foodId);
		List<Food> flist = fdi.getAllFood();
		if (flist.size() <=0 )
			return new ModelAndView("SearchFood", "searchfail", "Sorry food is not available");
		else
			return new ModelAndView("FoodList", "foodlist", flist);
	}

}

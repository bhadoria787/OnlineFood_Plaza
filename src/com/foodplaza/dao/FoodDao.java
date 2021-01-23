package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Food;

public interface FoodDao 
{
	int addFood(Food f);

	int deleteFood(int food_id);

	int updateFood(Food food);

	Food searchFoodById(int foodId);

	List<Food> getAllFood();

	/*
	 * List<Food> searchFoodByName(String foodName); List<Food>
	 * searchFoodByType(String foodType); List<Food> searchFoodByCategory(String
	 * foodCategory);
	 */

}

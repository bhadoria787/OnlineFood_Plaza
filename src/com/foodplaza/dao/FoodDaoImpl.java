package com.foodplaza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.foodplaza.pojo.Food;

public class FoodDaoImpl implements FoodDao {

	private JdbcTemplate jt1;
	public void setJt1(JdbcTemplate jt1) {
		this.jt1 = jt1;
	}

	public int addFood(Food f) {
		String sql="insert into food(food_id,food_name,food_type,food_category,price) values(?,?,?,?,?)";
		return jt1.update(sql,f.getFood_id(),f.getFood_name(),f.getFood_type(),f.getFood_category(),f.getPrice());
	}

	public int updateFood(Food f) {
		String sql="update food set food_name=?,food_type=?,food_category=?,price=? where food_id=?";
		return jt1.update(sql,f.getFood_name(),f.getFood_type(),f.getFood_category(),f.getPrice(),f.getFood_id());
	}

	public int deleteFood(int f_id) {
		String sql="delete from food where food_id=?";
		return jt1.update(sql,f_id);
	}

	public Food searchFoodById(int foodId) 
	{

		String getAll="select * from food where food_id=?";
		return jt1.queryForObject(getAll, new Object[] {foodId},new RowMapper<Food>()
				{
			@Override
			public Food mapRow(ResultSet rs, int in) throws SQLException 
			{
				Food f=new Food();
				f.setFood_id(rs.getInt(1));
				f.setFood_name(rs.getString(2));
				f.setFood_type(rs.getString(3));
				f.setFood_category(rs.getString(4));
				f.setPrice(rs.getInt(5));
				return f;
			}
				});
	}

	public List<Food> getAllFood() {
		String getAll="select * from food";
		return jt1.query(getAll, 
				new RowMapper<Food>(){  @Override
			                            public Food mapRow(ResultSet rs, int in) throws SQLException 
			                             {
				                          Food f=new Food();
				                          f.setFood_id(rs.getInt(1));
				                          f.setFood_name(rs.getString(2));
				                          f.setFood_type(rs.getString(3));
				                          f.setFood_category(rs.getString(4));
				                          f.setPrice(rs.getInt(5));
				                          return f;
			                             }
				                     }
		               );
	}
	
	public List<Food> searchFoodBycategory(String foodcategory)
	{
		String getAll="select * from food where food_category=?";
		return jt1.query(getAll, new Object[] {foodcategory}, new RowMapper<Food>()
				{
			@Override
			public Food mapRow(ResultSet rs, int in) throws SQLException {
				Food c=new Food(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
				return c;
			}
				});
	}
	
	public List<Food> searchFoodByType(String foodtype)
	{
		String getAll="select * from food where food_type=?";
		return jt1.query(getAll, new Object[] {foodtype}, new RowMapper<Food>()
				{
			@Override
			public Food mapRow(ResultSet rs, int in) throws SQLException {
				Food c=new Food(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
				return c;
			}
				});
	}
	
	public List<Food> searchFoodByName(String foodname)
	{
		String getAll="select * from food where food_name=?";
		return jt1.query(getAll, new Object[] {foodname}, new RowMapper<Food>()
				{
			@Override
			public Food mapRow(ResultSet rs, int in) throws SQLException {
				Food c=new Food(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
				return c;
			}
				});
	}

		
}

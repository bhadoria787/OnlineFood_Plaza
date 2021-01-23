package com.foodplaza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.foodplaza.pojo.Order_1;

public class OrderDaoImpl implements OrderDao {
	
	private JdbcTemplate jt1;
	
	public void setJt1(JdbcTemplate jt1) {
		this.jt1 = jt1;
	}
	

	public boolean placeOrder(Order_1 o) 
	{
		return jt1.update("INSERT INTO orders_1 (email_id , total_price , Date) VALUES(?,?,?)"
				,o.getEmail_id(),o.getTotal_price(),o.getDate())>0;	
	}

	public List<Order_1> showOrder() {

		String getAll="select * from orders_1";
		return jt1.query(getAll, new RowMapper<Order_1>()
				{
			@Override
			public Order_1 mapRow(ResultSet rs, int in) throws SQLException {
				Order_1 o=new Order_1(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
				
				return o;
			}
				});

	}
	public List<Order_1> Orderhistory(String EmailId) 
	{
				String getAll="select email_id,food_name,sum(quantity),sum(total_price),Date from cust_order_history where email_id=? group by email_id,food_name,Date";
				return jt1.query(getAll, new Object[] {EmailId}, new RowMapper<Order_1>()
						{
					@Override
					public Order_1 mapRow(ResultSet rs, int in) throws SQLException {
						Order_1 o=new Order_1( rs.getString(1),rs.getString(2),rs.getInt(3), rs.getDouble(4),rs.getString(5));
						
						return o;
					}
						});

			}

	
	public boolean custOrderhistory(Order_1 o) 
	{
		return jt1.update("INSERT INTO cust_order_history (email_id ,food_name,quantity,total_price ,Date) VALUES(?,?,?,?,?)"
				,o.getEmail_id(),o.getFood_name(),o.getQuantity(),o.getTotal_price(),o.getDate())>0;	
	}
	
	public boolean deleteCustOrderhistory(String custemailid) 
	{
		return jt1.update("DELETE FROM cust_order_history WHERE email_id=?",custemailid)>0;	
	}
	
}

package com.foodplaza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.foodplaza.pojo.Cart;


public class CartDaoImpl implements CartDao 
{
	private JdbcTemplate jt1;
	public void setJt1(JdbcTemplate jt1) {
		this.jt1 = jt1;
	}
	public JdbcTemplate getJt1(JdbcTemplate jt1) {
		return jt1;
	}
	
	public int addCart(Cart c)
	{
		String sql="insert into cart values(?,?,?,?,?,?)";
		return jt1.update(sql,c.getCart_id(),c.getCust_emailid(),c.getFood_id(),c.getFood_name(),c.getCart_quantity(),c.getTotal_price());
	}

	public List<Cart> showCart(String custemailId)
	{
		String getAll="select * from cart where cust_emailid=?";
		return jt1.query(getAll, new Object[] {custemailId}, new RowMapper<Cart>()
				{
			@Override
			public Cart mapRow(ResultSet rs, int in) throws SQLException {
				Cart c=new Cart();
				c.setCart_id(rs.getInt(1));
				c.setCust_emailid(rs.getString(2));
				c.setFood_id(rs.getInt(3));
				c.setFood_name(rs.getString(4));
				c.setCart_quantity(rs.getInt(5));
				c.setTotal_price(rs.getDouble(6));
				return c;
			}
				});
	}

	public int deleteCart(int cartId)
	{
		String sql="delete from cart where cart_id=?";
		return jt1.update(sql,cartId);
	}

	public int clearCart(String cust_emailId)
	{
		String sql="delete from cart where cust_emailid=?";
		return jt1.update(sql,cust_emailId);
	}

}

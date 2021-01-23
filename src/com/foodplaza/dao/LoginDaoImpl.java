package com.foodplaza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.foodplaza.pojo.Admin;
import com.foodplaza.pojo.Customer;

public class LoginDaoImpl implements LoginDao {
	
	private JdbcTemplate jt1;
	
	public void setJt1(JdbcTemplate jt1) 
	{
		this.jt1 = jt1;
	}
    
	boolean status;
	public boolean userlogin(String custEmailId,String pass) {
		String getAll="select * from customer where cust_email=? and cust_pass=?";
		try 
		{
		jt1.queryForObject(getAll, new Object[] {custEmailId,pass}, new RowMapper<Customer>()
				{
			@Override
			public Customer mapRow(ResultSet rs, int in) throws SQLException {
				
				Customer cu=new Customer(rs.getString(1),rs.getString(2));
				return cu;
			      }
				});
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
		
	}

	
	public boolean userchangePass(String userid, String newpass) 
	{
		return jt1.update("update customer set cust_pass=? where cust_email=?",newpass,userid)>0;
	}

	
	@Override
	public boolean adminLogin(String userid, String pass) 
	{
		String sql="select * from admin where admin_emailid=? and admin_pass=?";
		try
		{
		jt1.queryForObject(sql,  new Object[] {userid,pass}, new RowMapper<Admin>()
				{
			@Override
			public Admin mapRow(ResultSet rs, int in) throws SQLException {
				
				Admin a=new Admin(rs.getString(1),rs.getString(2));
				return a;
			}
				});
	   }
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}

	
	@Override
	public boolean adminChangePass(String userid, String newPass) 
	{
		return jt1.update("update admin set admin_pass=? where admin_emailid=?",newPass,userid)>0;

	}

}

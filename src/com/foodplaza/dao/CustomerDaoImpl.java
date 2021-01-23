package com.foodplaza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.foodplaza.pojo.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	private JdbcTemplate jt1;
	public void setJt1(JdbcTemplate jt1) {
		this.jt1 = jt1;
	}

	public int addCustomer(Customer c) {
		String sql="insert into customer values(?,?,?,?,?)";
		return jt1.update(sql,c.getCust_email(),c.getCust_name(),c.getCust_pass(),c.getCust_contact(),c.getCust_address());
	}

	public int updateCustomer(Customer c) {
		
		String sql="update customer set cust_name=?,cust_pass=?,cust_contact=?,cust_address=? where cust_email=?";
		return jt1.update(sql,c.getCust_name(),c.getCust_pass(),c.getCust_contact(),c.getCust_address(),c.getCust_email());
	}

	public int deleteCustomer(String custEmailId) {
		
		String sql="delete from customer where cust_email=?";
		return jt1.update(sql,custEmailId);
	}

	public Customer searchCustomerByEmailId(String custEmailId) 
	{
		String getAll="select * from customer where cust_email=?";
		return jt1.queryForObject(getAll, new Object[] {custEmailId}, new RowMapper<Customer>()
				{
			@Override
			public Customer mapRow(ResultSet rs, int in) throws SQLException {
				Customer cu=new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				return cu;
			}
				});
	}

	public List<Customer> getAllCustomer() {

		String getAll="select * from customer";
		return jt1.query(getAll, new RowMapper<Customer>()
				{
			@Override
			public Customer mapRow(ResultSet rs, int in) throws SQLException {
				Customer cu=new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				return cu;
			}
				});
	}

}

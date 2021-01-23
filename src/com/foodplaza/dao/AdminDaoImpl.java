package com.foodplaza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.foodplaza.pojo.Admin;

public class AdminDaoImpl {
	private JdbcTemplate jt1;

	public void setJt1(JdbcTemplate jt1) {
		this.jt1 = jt1;
	}

	public int addAdmin(Admin admin) {
		String sql = "insert into admin values(?,?)";
		return jt1.update(sql, admin.getAdmin_emailid(), admin.getAdmin_pass());
	}

	public Admin getAdmin() {

		return jt1.queryForObject("select * from admin", new RowMapper<Admin>() {
			@Override
			public Admin mapRow(ResultSet rs, int in) throws SQLException {
				Admin ad = new Admin(rs.getString(1), rs.getString(2));
				return ad;
			}
		});
	}
	
	public Admin searchAdminByEmailId(String adminEmailId) 
	{
		String getAll="select * from admin where admin_emailid=?";
		return jt1.queryForObject(getAll, new Object[] {adminEmailId}, new RowMapper<Admin>()
				{
			@Override
			public Admin mapRow(ResultSet rs, int in) throws SQLException 
			{
				Admin ad = new Admin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				return ad;
			}
				});
	}
	
	public int updateAdmin(Admin a) {
		String sql = "update admin set admin_name=?,admin_emailid=?,admin_pass=?,phone_no=?";
		return jt1.update(sql,a.getAdmin_name(),a.getAdmin_emailid(), a.getAdmin_pass(),a.getAdmin_phone_no());
	}
	
	public int removeAdmin(String admin_emailId) {
		String sql = "delete from admin where admin_emailid=?";
		return jt1.update(sql, admin_emailId);
	}

}

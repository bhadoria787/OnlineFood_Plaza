package com.foodplaza.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.foodplaza.pojo.Feedback;

public class FeedbackDaoImpl {

	JdbcTemplate jt1;

	public void setJt1(JdbcTemplate jt1) {
		this.jt1 = jt1;
		
	}

	public boolean addFeedback(Feedback f) 
	{
		String sql = "insert into feedback (cust_name,cust_emailid,review,suggestion) values(?,?,?,?)";
		return jt1.update(sql, f.getCustomer_name(), f.getCustomer_emailid(), f.getReview(),f.getSuggestion()) > 0;
	}

	public List<Feedback> getFeedback(String cust_email_id) 
	{
		String getAll = "select * from feedback where cust_emailid=?";
		return jt1.query(getAll, new Object[] { cust_email_id }, new RowMapper<Feedback>() {
			@Override
			public Feedback mapRow(ResultSet rs, int in) throws SQLException {
				Feedback f = new Feedback(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));

				return f;
			}
		});
	}
	
	
	
	public List<Feedback> getAllFeedback() 
	{
		String getAll = "select * from feedback";
		return jt1.query(getAll, new RowMapper<Feedback>() {
			@Override
			public Feedback mapRow(ResultSet rs, int in) throws SQLException {
				Feedback f = new Feedback(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));

				return f;
			}
		});
	}
	
	public boolean RemoveFeedback(int id)
	{
		return jt1.update("delete from feedback where feedback_id=?",id)>0;
	}
}

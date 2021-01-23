package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Feedback;

public interface FeedbackDao {
	
	boolean addFeedback(Feedback f);
	List<Feedback> getFeedback(String cust_email_id);

}

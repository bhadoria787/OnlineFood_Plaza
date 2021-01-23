package com.foodplaza.pojo;

public class Feedback {
	
	private int feedback_id;
	private String customer_name,customer_emailid,review,suggestion;
	public Feedback() {
		super();
	}
	public Feedback(int feedback_id, String customer_name, String customer_emailid, String review, String suggestion) {
		super();
		this.feedback_id = feedback_id;
		this.customer_name = customer_name;
		this.customer_emailid = customer_emailid;
		this.review = review;
		this.suggestion = suggestion;
	}
	public int getFeedback_id() {
		return feedback_id;
	}
	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_emailid() {
		return customer_emailid;
	}
	public void setCustomer_emailid(String customer_emailid) {
		this.customer_emailid = customer_emailid;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	@Override
	public String toString() {
		return "Feedback [feedback_id=" + feedback_id + ", customer_name=" + customer_name + ", customer_emailid="
				+ customer_emailid + ", review=" + review + ", suggestion=" + suggestion + "]";
	}
	
	

}

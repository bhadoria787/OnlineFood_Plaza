package com.foodplaza.dao;

public interface LoginDao {
	boolean userlogin(String userid,String pass);
	boolean userchangePass(String userid, String newpass);
	boolean adminLogin(String userid,String pass);
	boolean adminChangePass(String userid, String newPass);

}

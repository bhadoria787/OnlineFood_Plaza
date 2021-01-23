package com.foodplaza.pojo;

public class Admin 
{
	private String admin_name,admin_emailid;
	private String admin_pass,admin_phone_no;
	
	

	
	public Admin() {
		super();
	}
	

	public Admin(String admin_emailid, String admin_pass) {
		super();
		this.admin_emailid = admin_emailid;
		this.admin_pass = admin_pass;
	}

	

	public Admin(String admin_name, String admin_emailid, String admin_pass, String admin_phone_no) {
		super();
		this.admin_name = admin_name;
		this.admin_emailid = admin_emailid;
		this.admin_pass = admin_pass;
		this.admin_phone_no = admin_phone_no;
	}


	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_emailid() {
		return admin_emailid;
	}

	public void setAdmin_emailid(String admin_emailid) {
		this.admin_emailid = admin_emailid;
	}

	public String getAdmin_pass() {
		return admin_pass;
	}

	public void setAdmin_pass(String admin_pass) {
		this.admin_pass = admin_pass;
	}

	public String getAdmin_phone_no() {
		return admin_phone_no;
	}

	public void setAdmin_phone_no(String admin_phone_no) {
		this.admin_phone_no = admin_phone_no;
	}


	@Override
	public String toString() {
		return "Admin [admin_name=" + admin_name + ", admin_emailid=" + admin_emailid + ", admin_pass=" + admin_pass
				+ ", admin_phone_no=" + admin_phone_no + "]";
	}
	

	
}

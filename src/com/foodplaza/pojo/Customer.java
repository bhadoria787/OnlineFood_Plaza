package com.foodplaza.pojo;

public class Customer {
	
    private String  cust_email,cust_name, cust_pass,cust_contact;
	
	private String cust_address;

	public Customer() {
		super();
	}

	public Customer(String cust_email, String cust_pass) {
		super();
		this.cust_email = cust_email;
		this.cust_pass = cust_pass;
	}

	public Customer(String cust_email, String cust_name, String cust_pass, String cust_contact, String cust_address) {
		super();
		this.cust_email = cust_email;
		this.cust_name = cust_name;
		this.cust_pass = cust_pass;
		this.cust_contact = cust_contact;
		this.cust_address = cust_address;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_pass() {
		return cust_pass;
	}

	public void setCust_pass(String cust_pass) {
		this.cust_pass = cust_pass;
	}

	public String getCust_contact() {
		return cust_contact;
	}

	public void setCust_contact(String cust_contact) {
		this.cust_contact = cust_contact;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	@Override
	public String toString() {
		return "Customer [cust_email=" + cust_email + ", cust_name=" + cust_name + ", cust_pass=" + cust_pass
				+ ", cust_contact=" + cust_contact + ", cust_address=" + cust_address + "]";
	}
	
	

}

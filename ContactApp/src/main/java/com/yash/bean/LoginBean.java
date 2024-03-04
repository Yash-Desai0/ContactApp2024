package com.yash.bean;

public class LoginBean {

	private String email;
	private String pass;
	
	public LoginBean() {
		 System.out.println("This is Login Bean");
	}

	public LoginBean(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public String getPass() {
		return pass;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "LoginBean [email=" + email + ", pass=" + pass + "]";
	}

}

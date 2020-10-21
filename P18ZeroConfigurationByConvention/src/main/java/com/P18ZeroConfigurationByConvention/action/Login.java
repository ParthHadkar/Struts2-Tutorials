package com.P18ZeroConfigurationByConvention.action;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport{
	private String username,password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() {
		String result = "";
		if(username.equals("Admin") && password.equals("Admin")) {
			result ="success";
		}
		else {
			result ="error";
		}
		return result;
	}
}

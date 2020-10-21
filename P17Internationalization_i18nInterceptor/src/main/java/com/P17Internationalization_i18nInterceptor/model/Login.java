package com.P17Internationalization_i18nInterceptor.model;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {
	private String username, password;//,request_locale;

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

	
	/*
	 * public String getRequest_locale() { return request_locale; }
	 * 
	 * public void setRequest_locale(String request_locale) { this.request_locale
	 * =request_locale; }
	 */
	 

	public String execute() {
		String result = "";
		if (username.equals("Admin") && password.equals("Admin")) {
			result = "success";
		} else {
			result = "error";
		}
		return result;
	}
}

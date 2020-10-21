package com.p15ServletActionContext_SessionAware.model;

import java.util.Map;


import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class Login implements SessionAware{
	private String username,password;
	
	private SessionMap<String, Object> session;

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
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session =(SessionMap<String, Object>) session;
	}
	
	public String execute() {
		String result = "";
		if(username.equals("Admin") && password.equals("Admin")) {
			session.put("login", true);
			session.put("username", username);
			result ="success";
		}
		else {
			result ="error";
		}
		return result;
	}

	public String logout() {
		if(session != null) {
			session.invalidate();
			session.clear();
		}
		return "success";
	}
	
}

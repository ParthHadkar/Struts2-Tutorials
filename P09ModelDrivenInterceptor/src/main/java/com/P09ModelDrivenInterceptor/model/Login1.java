package com.P09ModelDrivenInterceptor.model;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class Login1{
	
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute() {
		//user = new User();
		String result = "";
		System.out.println("user "+user);
		if(user.getUsername() == null || user.getPassword() == null) {
			result ="error";
		}
		else if(user.getUsername().equals("Admin") && user.getPassword().equals("Admin")) {
			result ="success";
		}
		else {
			result ="error";
		}
		return result;
	}
}

package com.p12CustomValidation_WorkflowInterceptor.model;

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

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	@Override
	public void validate() {
		if(username.trim().isEmpty() && password.trim().isEmpty()) {
			System.out.println("All Field Are Empty!!!!");
			addActionError("All Field Are Empty!!!!");//Action class Level
		}
		else if(username.trim().isEmpty()) {
			System.out.println("Username Can't Be Empty!!!!");
			addFieldError("username","Username Can't Be Empty!!!!");//Field Level
		}
		else if(password.trim().isEmpty()) {
			System.out.println("Password Can't Be Empty!!!!");
			addFieldError("Password","Password Can't Be Empty!!!!");
		}
		else if(password.trim().length()<8) {
			System.out.println("Password Must Be Alteast 8 Character!!!!");
			addFieldError("Password","Password Must Be Alteast 8 Character!!!!");
		}
		  else { 
			  System.out.println("Thanks For Entering Required Details");
			  addActionMessage("Thanks For Entering Required Details");
			  }
		 
	}

	
	public String execute() {
		String result = "";
		if(getUsername() == null || getPassword() == null) {
			result ="error";
		}
		else if(getUsername().equals("Admin") && getPassword().equals("Admin123")) {
			result ="success";
		}
		else {
			result ="error";
		}
		return result;
	}
}

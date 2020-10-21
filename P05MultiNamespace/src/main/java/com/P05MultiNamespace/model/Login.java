package com.P05MultiNamespace.model;

public class Login {
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

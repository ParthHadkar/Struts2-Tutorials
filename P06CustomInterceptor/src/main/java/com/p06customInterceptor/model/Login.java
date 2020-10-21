package com.p06customInterceptor.model;

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
		System.out.println("LoginAction username"+username);
		if(username.equals("Admin") && password.equals("Admin")) {
			result ="success";
		}
		else {
			result ="error";
		}
		return result;
	}
}

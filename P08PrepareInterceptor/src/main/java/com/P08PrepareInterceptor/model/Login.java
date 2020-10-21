package com.P08PrepareInterceptor.model;

import com.opensymphony.xwork2.Preparable;

public class Login implements Preparable{
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
	public void prepare() throws Exception {
		System.out.println("Preparation Logic");
		if(username != null || password != null) {
		setUsername(getUsername().replaceAll(" ", ""));
		setPassword(getPassword().replaceAll(" ", ""));
		char[] uname = getUsername().toCharArray();
		if(uname.length!=0) {
			uname[0] = Character.toUpperCase(uname[0]);
			setUsername(new String(uname));
		}
		char[] upass = getPassword().toCharArray();
		if(upass.length!=0) {
			upass[0] = Character.toUpperCase(upass[0]);
			setPassword(new String(upass));
		}
		}
	}
	
	public String execute() {
		System.out.println("Actual Logic");
		String result = "";
		if(username == null || password == null) {
			result ="error";
		}
		else if(username.equals("Admin") && password.equals("Admin")) {
			result ="success";
		}
		else {
			result ="error";
		}
		return result;
	}
}

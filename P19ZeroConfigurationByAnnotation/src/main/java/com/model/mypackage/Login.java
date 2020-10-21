package com.model.mypackage;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

//@ParentPackage("package1")
@Action(value="login",
results={
	@Result(name = "success",type = "dispatcher",location = "/myResults/login-success.jsp"),
	@Result(name = "error",location = "/myResults/login-error.jsp")
})
/*@Results({
	@Result(name = "success",type = "dispatcher",location = "/myResults/login-success.jsp"),
	@Result(name = "error",location = "/myResults/login-error.jsp")
})*/
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
	//@Action(value = "/check")
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

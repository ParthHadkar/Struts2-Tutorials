package com.p27ExceptionInterceptorAnnotation.model;

import javax.annotation.Generated;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@Results({
	@Result(name = "myexception",location = "GlobalResult.jsp")
})
@ExceptionMappings({
	@ExceptionMapping(result = "myexception",exception = "java.lang.Exception")
})
public class Login extends ActionSupport{
	
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	@Action(value = "Login",
			interceptorRefs = {
					@InterceptorRef(value = "params"),
					@InterceptorRef(value = "exception")
			},
			results={
					@Result(name = "success",type = "dispatcher",location = "Success.jsp"),
					@Result(name = "error",location = "Error.jsp")
				})//,exceptionMappings = 
	public String execute() {
		//user = new User();
		String result = "";
		System.out.println("user "+user);
		/*if(user.getUsername() == null || user.getPassword() == null) {
			result ="myexception";
		}
		else*/ if(user.getUsername().equals("Admin") && user.getPassword().equals("Admin")) {
			result ="success";
		}
		else {
			result ="error";
		}
		return result;
	}
}

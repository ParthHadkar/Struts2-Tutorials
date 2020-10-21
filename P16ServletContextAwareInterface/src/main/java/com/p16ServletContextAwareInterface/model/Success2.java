package com.p16ServletContextAwareInterface.model;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

public class Success2 {

	public String execute() {
		String result = "";
		ServletContext context = ServletActionContext.getServletContext();
		String username = (String)context.getAttribute("username");
		if(username != null) {
			result ="success";
		}
		else {
			result ="error";
		}
		return result;
	}
}

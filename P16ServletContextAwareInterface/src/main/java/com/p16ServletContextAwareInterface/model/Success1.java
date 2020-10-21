package com.p16ServletContextAwareInterface.model;


import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

public class Success1 implements ServletContextAware{
	
	@Override
	public void setServletContext(ServletContext context) {
		context.setAttribute("username", "nitin");
		
	}
	
	public String execute() {
		return "success";
	}

}

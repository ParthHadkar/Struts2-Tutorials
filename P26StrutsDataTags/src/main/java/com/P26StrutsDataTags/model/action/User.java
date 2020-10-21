package com.P26StrutsDataTags.model.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

public class User {
	
	public String execute() {
		List<String> names = new ArrayList<String>();
		names.add("nitin");
		names.add("nikhil");
		names.add("hari");
		names.add("parth");
		ServletActionContext.getServletContext().setAttribute("names", names);
		return "success";
	}
}

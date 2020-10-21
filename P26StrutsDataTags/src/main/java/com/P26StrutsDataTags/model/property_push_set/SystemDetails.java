package com.P26StrutsDataTags.model.property_push_set;

import com.opensymphony.xwork2.ActionSupport;

public class SystemDetails extends ActionSupport{
	private Environment environment = new Environment("Development","1");
	private String operatingSystem = "Fedora 31";
	public SystemDetails() {
	}
	public SystemDetails(Environment environment, String operatingSystem) {
		this.environment = environment;
		this.operatingSystem = operatingSystem;
	}
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public Environment getEnvironment() {
		return environment;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public String execute() throws Exception {
		return SUCCESS;
	}
}

package com.P26StrutsDataTags.model.property_push_set;

public class Environment {
	private String name,version;
	public Environment() {}
	public Environment(String name,String version) {
		this.name = name;
		this.version = version;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getName() {
		return name;
	}
	public String getVersion() {
		return version;
	}
}

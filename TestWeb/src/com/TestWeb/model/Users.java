package com.TestWeb.model;


import java.io.File;
import java.util.List;

import javax.servlet.http.Part;

import com.TestWeb.dao.UsersDao;

public class Users  {
	private String username,emailId,gender;
	private long mobileNo;
	private int age;
	private Part userimage;
	private String userimageFileName,userimageContentType;
	private String userid,imagebyte,userPath;
	
	public Users() {}
	
	
	public Users(String username, String emailId, String gender, long mobileNo, int age, Part userimage,
			String userimageFileName, String userimageContentType) {
		this.username = username;
		this.emailId = emailId;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.age = age;
		this.userimage = userimage;
		this.userimageFileName = userimageFileName;
		this.userimageContentType = userimageContentType;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Part getUserimage() {
		return userimage;
	}

	public void setUserimage(Part userimage) {
		this.userimage = userimage;
	}

	public String getUserimageFileName() {
		return userimageFileName;
	}

	public void setUserimageFileName(String userimageFileName) {
		this.userimageFileName = userimageFileName;
	}

	public String getUserimageContentType() {
		return userimageContentType;
	}

	public void setUserimageContentType(String userimageContentType) {
		this.userimageContentType = userimageContentType;
	}
	
	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getImagebyte() {
		return imagebyte;
	}


	public void setImagebyte(String imagebyte) {
		this.imagebyte = imagebyte;
	}


	public String getUserPath() {
		return userPath;
	}


	public void setUserPath(String userPath) {
		this.userPath = userPath;
	}


}

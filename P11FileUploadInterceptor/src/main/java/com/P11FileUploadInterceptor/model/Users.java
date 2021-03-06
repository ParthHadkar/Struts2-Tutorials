package com.P11FileUploadInterceptor.model;


import java.io.File;
import java.util.List;

import com.P11FileUploadInterceptor.dao.UsersDao;
import com.opensymphony.xwork2.ActionSupport;

public class Users extends ActionSupport {//implements Action
	//ActionSupport Uses Action, Validateable, ValidationAware, TextProvider, LocaleProvider, Serializable 
	
	private String username,emailId,gender;
	private long mobileNo;
	private int age;
	private File userimage;
	private String userimageFileName,userimageContentType;
	private String userid,imagebyte,userPath;
	
	public Users() {}
	
	
	public Users(String username, String emailId, String gender, long mobileNo, int age, File userimage,
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
	
	public File getUserimage() {
		return userimage;
	}

	public void setUserimage(File userimage) {
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


	@Override
	public String toString() {
		return "Users [username=" + username + ", emailId=" + emailId + ", gender=" + gender + ", mobileNo=" + mobileNo
				+ ", age=" + age + ", userimage=" + userimage + ", userimageName=" + userimageFileName
				+ ", userimageContentType=" + userimageContentType + "]";
	}

	public String execute() {
		String result = ERROR;
		Users user = new Users(username, emailId, gender, mobileNo, age, 
				userimage, userimageFileName, userimageContentType);
		System.out.println("user "+user.toString());
		if(UsersDao.checkUser(mobileNo, emailId)) {
			result = INPUT;
		}
		else {
			List<Object> objectList = UsersDao.addUser(user);
			if(Integer.valueOf(objectList.get(0).toString())>0){
			userid = objectList.get(1).toString();
			imagebyte  = objectList.get(2).toString();
			userPath  = objectList.get(3).toString();
			result = SUCCESS;
			}
		}
		return result;
	}
}

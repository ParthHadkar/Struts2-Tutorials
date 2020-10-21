package com.p13BundledValidation.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.p13BundledValidation.dao.UsersDao;

public class Users extends ActionSupport {//implements Action
	//ActionSupport Uses Action, Validateable, ValidationAware, TextProvider, LocaleProvider, Serializable 
	
	private String username,emailId,gender,url,password,cPassword;
	private Date dob;
	private long mobileNo;
	private int age;
	private double height;
	
	public Users() {}

	public Users(String username, String emailId, String gender, String url, Date dob, String password,
			String cPassword, long mobileNo, int age, double height) {
		this.username = username;
		this.emailId = emailId;
		this.gender = gender;
		this.url = url;
		this.dob = dob;
		this.password = password;
		this.cPassword = cPassword;
		this.mobileNo = mobileNo;
		this.age = age;
		this.height = height;
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



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getcPassword() {
		return cPassword;
	}



	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
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



	public double getHeight() {
		return height;
	}



	public void setHeight(double height) {
		this.height = height;
	}



	public String execute() {
		String result = ERROR;
		Users user = new Users(username, emailId, gender, url, dob, password, cPassword, mobileNo, age, height);
		System.out.println("user "+user.toString());
		if(UsersDao.checkUser(mobileNo, emailId)) {
			result = INPUT;
		}
		else if(UsersDao.addUser(user)>0){
			result = SUCCESS;
		}
		return result;
	}
}

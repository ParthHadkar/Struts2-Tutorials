package com.p02action_actionSupport.model;


import com.opensymphony.xwork2.ActionSupport;
import com.p02action_actionSupport.dao.UsersDao;

public class Users extends ActionSupport {//implements Action
	//ActionSupport Uses Action, Validateable, ValidationAware, TextProvider, LocaleProvider, Serializable 
	
	private String username,emailId,gender;
	private long mobileNo;
	private int age;
	
	public Users() {}
	
	public Users(String username, String emailId, String gender, long mobileNo, int age) {
		this.username = username;
		this.emailId = emailId;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.age = age;
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
	
	@Override
	public String toString() {
		return "Users [username=" + username + ", emailId=" + emailId + ", gender=" + gender + ", mobileNo=" + mobileNo
				+ ", age=" + age + "]";
	}

	public String execute() {
		String result = ERROR;
		Users user = new Users(username, emailId, gender, mobileNo, age);
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

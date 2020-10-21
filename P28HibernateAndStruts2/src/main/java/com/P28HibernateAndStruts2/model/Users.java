package com.P28HibernateAndStruts2.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "users")
public class Users  {	
	
	@Id
	@GeneratedValue
	@Column(name = "Id",length = 20)
	private int id;
	@Column(name = "Name",length = 20)
	private String username;
	@Column(name = "EmailId",length = 20)
	private String emailId;
	@Column(name = "Gender",length = 20)
	private String gender;
	@Column(name = "MobileNo",length = 20)
	private long mobileNo;
	@Column(name = "Age",length = 20)
	private int age;
	
	public Users() {}
	
	public Users(String username, String emailId, String gender, long mobileNo, int age) {
		this.username = username;
		this.emailId = emailId;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.age = age;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
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

}

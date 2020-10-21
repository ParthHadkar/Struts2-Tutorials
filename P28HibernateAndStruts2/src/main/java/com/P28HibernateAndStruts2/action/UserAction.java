package com.P28HibernateAndStruts2.action;

import java.util.List;

import com.P28HibernateAndStruts2.dao.UsersDao;
import com.P28HibernateAndStruts2.model.Users;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<Users>{
	
	private Users users;
	private List<Users> usersList;
	@Override
	public Users getModel() {
		return users = new Users();
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}
	public List<Users> getUsersList() {
		return usersList;
	}
	public String execute() {
		String result = ERROR;
		System.out.println("users "+users.toString());
		if(UsersDao.checkUser(users.getMobileNo(), users.getEmailId(),"Jpa")) {
			//"Hibernate" "Jpa"
			result = INPUT;
		}
		else if(UsersDao.addUser(users,"Jpa")>0){
			result = SUCCESS;
		}
		return result;
	}
	public String usersList() {
		try {
			setUsersList(UsersDao.getUsers("Jpa"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}

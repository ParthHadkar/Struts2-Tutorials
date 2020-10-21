package com.P28HibernateAndStruts2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.P28HibernateAndStruts2.common.Database;
import com.P28HibernateAndStruts2.model.Users;

public class UsersDao {
	
	public static boolean checkUser(long mobileNo,String emailId,String dbType) {
		boolean result = false;
		try {
			if(dbType.equalsIgnoreCase("Hibernate")) {
				Session session = (Session) Database.dbConnection(dbType);
				Query query = session.createQuery("from Users u WHERE u.mobileNo=:mobileNo OR"
						+ " u.emailId=:emailId");
				query.setParameter("mobileNo", mobileNo);
				query.setParameter("emailId", emailId);
				Object object = query.uniqueResult();
				if(object != null) {
					System.out.println("object "+object);
					result = true;
				}
			}
			else if(dbType.equalsIgnoreCase("Jpa")) {
				EntityManager entityManager = (EntityManager) Database.dbConnection(dbType);
				javax.persistence.Query query = entityManager.createQuery("from Users u WHERE u.mobileNo=:mobileNo OR"
						+ " u.emailId=:emailId");
				query.setParameter("mobileNo", mobileNo);
				query.setParameter("emailId", emailId);
				Object object = query.getSingleResult();
				if(object != null) {
					System.out.println("object "+object);
					result = true;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static int addUser(Users user,String dbType) {
		int result = 0;
		
		try {
			if(dbType.equalsIgnoreCase("Hibernate")) {
				Session session = (Session) Database.dbConnection(dbType);
				Transaction tx = session.beginTransaction();
				result = (int) session.save(user);
				tx.commit();
				session.flush();
			}
			else if(dbType.equalsIgnoreCase("Jpa")) {
				EntityManager entityManager = (EntityManager) Database.dbConnection(dbType);
				EntityTransaction tx = entityManager.getTransaction();
				tx.begin();
				entityManager.persist(user);
				tx.commit();
				result = user.getId(); 
				//entityManager.flush();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static List<Users> getUsers(String dbType) {
		List<Users> users = null;
		try {
			if(dbType.equalsIgnoreCase("Hibernate")) {
				Session session = (Session) Database.dbConnection(dbType);
				Query query = session.createQuery("from Users");
				users = query.list();
			}
			else if(dbType.equalsIgnoreCase("Jpa")) {
				EntityManager entityManager = (EntityManager) Database.dbConnection(dbType);
				javax.persistence.Query query = entityManager.createQuery("from Users");
				users = query.getResultList();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
}

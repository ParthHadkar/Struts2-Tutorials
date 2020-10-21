package com.P28HibernateAndStruts2.common;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Database {
	private static SessionFactory sf = null;
	private static Session session = null;
	private static EntityManagerFactory emf = null;
	private static EntityManager entityManager = null;
	
	public static Object dbConnection(String dbType){
		Object dbObject = null;
		try {
			if(dbType.equalsIgnoreCase("Hibernate")) {
				if(sf == null) {
					Configuration con = new Configuration().configure();
					ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
					sf = con.buildSessionFactory(reg);
				}
				session = sf.openSession();
				dbObject = session;
			}
			else if(dbType.equalsIgnoreCase("Jpa")) {
				if(emf == null) {
					emf = Persistence.createEntityManagerFactory("unit1");
				}
				entityManager = emf.createEntityManager();
				dbObject = entityManager;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		return dbObject;
	}
	
	public static void dbClose(String dbType) {
		try {
			if(dbType.equalsIgnoreCase("Hibernate")) {
				if(session != null) {
					//sf.close();
					session.close();
				}
			}
			else if(dbType.equalsIgnoreCase("Jpa")) {
				if(entityManager != null) {
					//emf.close();
					entityManager.close();
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

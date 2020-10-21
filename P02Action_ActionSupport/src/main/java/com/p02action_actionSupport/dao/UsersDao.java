package com.p02action_actionSupport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.p02action_actionSupport.common.Database;
import com.p02action_actionSupport.model.Users;

public class UsersDao {
	
	public static boolean checkUser(long mobileNo,String emailId) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Database.getDBConnection();
			String query = "SELECT mobileNo,emailId FROM users WHERE mobileNo=? OR emailId=?";
			ps = conn.prepareStatement(query);
			ps.setLong(1, mobileNo);
			ps.setString(2, emailId);
			rs = ps.executeQuery();
			rs.last();
			int row = rs.getRow();
			System.out.println("row "+row);
			rs.beforeFirst();
			if(rs.next()) {
				result = true;
			}
			rs.close();
			ps.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static int addUser(Users user) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = Database.getDBConnection();
			String query = "INSERT INTO users(Name,MobileNo,EmailId,Age,Gender) VALUES(?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setLong(2, user.getMobileNo());
			ps.setString(3, user.getEmailId());
			ps.setInt(4, user.getAge());
			ps.setString(5, user.getGender());
			result = ps.executeUpdate();
			System.out.println("row "+result);
			ps.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

package com.P21BundledValidationZeroConfigurationByAnnotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.P21BundledValidationZeroConfigurationByAnnotation.common.Database;
import com.P21BundledValidationZeroConfigurationByAnnotation.model.Users;

public class UsersDao {
	
	public static boolean checkUser(long mobileNo,String emailId) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Database.getDBConnection();
			String query = "SELECT mobileNo,emailId FROM users_val WHERE mobileNo=? OR emailId=?";
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
			System.out.println("e "+e.getMessage());
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
			String query = "INSERT INTO users_val(Name,MobileNo,EmailId,Age,Gender,Height,Url,Dob,Password) VALUES(?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setLong(2, user.getMobileNo());
			ps.setString(3, user.getEmailId());
			ps.setInt(4, user.getAge());
			ps.setString(5, user.getGender());
			ps.setDouble(6, user.getHeight());
			ps.setString(7, user.getUrl());
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			String dob = format.format(user.getDob());
			ps.setString(8, dob);
			ps.setString(9, user.getcPassword());
			result = ps.executeUpdate();
			System.out.println("row "+result);
			ps.close();
			conn.close();
		}catch (Exception e) {
			System.out.println("e "+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
}

package com.P11FileUploadInterceptor.dao;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.P11FileUploadInterceptor.common.Database;
import com.P11FileUploadInterceptor.model.Users;

public class UsersDao {
	
	public static boolean checkUser(long mobileNo,String emailId) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Database.getDBConnection();
			String query = "SELECT mobileNo,emailId FROM users_img WHERE mobileNo=? OR emailId=?";
			ps = conn.prepareStatement(query);
			ps.setLong(1, mobileNo);
			ps.setString(2, emailId);
			rs = ps.executeQuery();
			rs.last();
			int row = rs.getRow();
			System.out.println("checkUser row "+row);
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

	public static List<Object> addUser(Users user) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		List<Object> objectList = new ArrayList<Object>();
		try {
			byte[] userImageByte =  FileUtils.readFileToByteArray(user.getUserimage());
					//Files.readAllBytes(Paths.get(user.getUserimage().getAbsolutePath()));
			String imageName = user.getUserimageFileName();
			String imageType = user.getUserimageContentType();
			InputStream userImageIS = new ByteArrayInputStream(userImageByte);
			String filePath =ServletActionContext.getServletContext().getRealPath("/");//.concat("UserImage");
			String filePath1 =filePath.substring(0,filePath.indexOf(".metadata"))
					.concat(filePath.substring(filePath.indexOf("/wtpwebapps/")+"/wtpwebapps/".length())
							+"src/main/webapp/UserImage");
			// "/home/p-pc/linuxprograming/Java Programs/StrutsP/P11FileUploadInterceptor/src/main/webapp/UserImage";
			String userPath = "UserImage"+File.separator+imageName;
			String imageByteString = Base64.getEncoder().encodeToString(userImageByte);
			conn = Database.getDBConnection();
			String query = "INSERT INTO users_img(Name,MobileNo,EmailId,Age,Gender,Image,ImagePath,ImageName,ImageType) VALUES(?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUsername());
			ps.setLong(2, user.getMobileNo());
			ps.setString(3, user.getEmailId());
			ps.setInt(4, user.getAge());
			ps.setString(5, user.getGender());
			ps.setBinaryStream(6, userImageIS);
			ps.setString(7, userPath);
			ps.setString(8, imageName);
			ps.setString(9, imageType);
			result = ps.executeUpdate();
			//ServletActionContext.getServletContext().getResource("/").getPath()
			System.out.println(filePath1+" Insert row "+result);
			ResultSet rs = ps.getGeneratedKeys();
			int id = 0;
			if(rs.next()) {
				id = rs.getInt(1);
			}
			FileOutputStream stream = new FileOutputStream(filePath1+File.separator+imageName);
			stream.write(userImageByte);
			stream.flush();
			stream.close();
			objectList.add(result);
			objectList.add(id);
			objectList.add(imageByteString);
			objectList.add(userPath);
			ps.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return objectList;
	}
}

package com.TestWeb.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserImage
 */
@WebServlet("/UserImage")
public class UserImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
			response.setContentType("text/html;charset=UTF-8;");
			//PrintWriter out = response.getWriter();
			String Id = request.getParameter("Id");
			byte[] userImage = null;
			String ImageType = "",ImageName = "";
			String query = "SELECT Image,ImageType,ImageName FROM users_img WHERE Id=?";
			Connection conn = Database.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, Id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				userImage = rs.getBytes(1);
				ImageType = rs.getString(2);
				ImageName = rs.getString(3);
			}
			if(userImage != null) {
				response.setContentType(ImageType);
				//response.setHeader("Content-Dispostion", "attachment; filename=\""+ImageName+"\"");
				response.addHeader("Cache-Control", "no-cache, no-store, no-revalidate");
				response.addHeader("Pragma","no-cache");
				response.setDateHeader("Expires", 0);
				
				response.setContentLength(userImage.length);
				response.getOutputStream().write(userImage);
				response.getOutputStream().flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.TestWeb.common;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.TestWeb.dao.UsersDao;
import com.TestWeb.model.Users;

/**
 * Servlet implementation class Register
 */
@MultipartConfig
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
			response.setContentType("text/html;charset=UTF-8;");
			PrintWriter out = response.getWriter();
			String username = request.getParameter("Username");
			String emailId = request.getParameter("emailId");
			String gender = request.getParameter("gender");
			long mobileNo  = Long.parseLong(request.getParameter("mobileNo"));
			int age  = Integer.parseInt(request.getParameter("age"));
			Part userimage  = request.getPart("Userimage");
			String userimageFileName = userimage.getSubmittedFileName();
			String userimageContentType = userimage.getContentType();
			String userid="",imagebyte="",userPath="";
			if(UsersDao.checkUser(mobileNo, emailId)) {
				//response.sendRedirect("Register.jsp");
				out.print("<script>");
				out.print("alert('Invalid Username And Password');");
				out.print("location='Register.jsp';");
				out.print("</script>");
			}
			else {
				Users user = new Users(username, emailId, gender, mobileNo, age, 
						userimage, userimageFileName, userimageContentType);
				List<Object> objectList = UsersDao.addUser(user,request);
				if(Integer.valueOf(objectList.get(0).toString())>0){
				userid = objectList.get(1).toString();
				imagebyte  = objectList.get(2).toString();
				userPath  = objectList.get(3).toString();
				request.setAttribute("username",username);
				request.setAttribute("mobileNo",mobileNo);
				request.setAttribute("emailId",emailId);
				request.setAttribute("age",age);
				request.setAttribute("gender",gender);
				request.setAttribute("userimageFileName",userimageFileName);
				request.setAttribute("userimageContentType",userimageContentType);
				request.setAttribute("userPath",userPath);
				request.setAttribute("userid",userid);
				request.setAttribute("imagebyte",imagebyte);
				request.setAttribute("userimage",userimage);
				System.out.println("username"+username+
				"\nmobileNo"+mobileNo+
				"\nemailId"+emailId+
				"\nage"+age+
				"\ngender"+gender+
				"\nuserimageFileName"+userimageFileName+
				"\nuserimageContentType"+userimageContentType+
				"\nuserPath"+userPath+
				"\nuserid"+userid+
				"\nuserimage"+userimage);
				RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
				rd.forward(request, response);
				}
				else {
					response.sendRedirect("Error.jsp");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

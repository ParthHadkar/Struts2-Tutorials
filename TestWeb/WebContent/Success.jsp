<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
<%
String username = request.getParameter("Username");
String emailId = request.getParameter("emailId");
String gender = request.getParameter("gender");
long mobileNo  = Long.parseLong(request.getParameter("mobileNo"));
int age  = Integer.parseInt(request.getParameter("age"));
Part userimage  =request.getPart("Userimage");
String userimageFileName = (String)request.getAttribute("userimageFileName");
String userimageContentType =(String) request.getAttribute("userimageContentType");
String userid = (String)request.getAttribute("userid");
String imagebyte = (String)request.getAttribute("imagebyte");
String userPath = (String)request.getAttribute("userPath");
System.out.println("username"+request.getAttribute("username")+
		"\nmobileNo"+mobileNo+
		"\nemailId"+emailId+
		"\nage"+age+
		"\ngender"+gender+
		"\nuserimageFileName"+userimageFileName+
		"\nuserimageContentType"+userimageContentType+
		"\nuserPath"+userPath+
		"\nuserid"+userid+
		"\nuserimage"+userimage);
%>
<h1>username: <%= username%><br/>
mobileNo: <%out.print(mobileNo); %><br/>
emailId: <%= emailId%><br/>
age: <%= age%><br/>
gender: <%= gender%><br/>
Image Name: <%= userimageFileName%><br/>
Image Content Type:${userimageContentType}<br/>
Image Path: <%= userimage%><br/>
</h1>
<img alt="imagePath" src="<%= userPath%>" width="500px" height="300px"/><br/>
<img alt="userId" src="UserImage?Id=<%= userid%>" width="500px" height="300px"/><br/>
<img alt="imageByte" src="data:image/*;base64,<%= imagebyte%>" width="500px" height="300px"/><br/>
</body>
</html>
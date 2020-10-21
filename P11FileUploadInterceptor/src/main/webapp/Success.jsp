<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
<h1>username: <s:property value="username"/><br/>
mobileNo: <s:property value="mobileNo"/><br/>
emailId: <s:property value="emailId"/><br/>
age: <s:property value="age"/><br/>
gender: <s:property value="gender"/><br/>
Image Name: <s:property value="userimageFileName"/><br/>
Image Content Type: <s:property value="userimageContentType"/><br/>
Image Path: <s:property value="userimage"/><br/>
</h1>
<img alt="imagePath" src="<s:property value="userPath"/>" width="500px" height="300px"/><br/>
<img alt="userId" src="UserImage?Id=<s:property value="userid"/>" width="500px" height="300px"/><br/>
<img alt="imageByte" src="data:image/jpeg;base64,<s:property value="imagebyte"/>" width="500px" height="300px"/><br/>
</body>
</html>
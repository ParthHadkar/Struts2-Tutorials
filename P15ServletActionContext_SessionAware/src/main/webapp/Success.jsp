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
<a href="Logout">Logout</a>
<h1>Welcome <s:property value="#session.username"/></h1><!-- #session['username'] -->
</body>
</html>
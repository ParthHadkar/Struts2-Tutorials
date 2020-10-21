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
<h1>Welcome <s:property value="username"/></h1>
<a href="lionMenu">Lion</a> <a href="<s:url action = "tigerMenu"/>">Tiger</a>
</body>
</html>
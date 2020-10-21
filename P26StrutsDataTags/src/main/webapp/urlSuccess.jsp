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
<h1>Include Tags:</h1>
<s:url action="generator" var="gen"/>
<a href="<s:property value="%{gen}"/>"><s:property value="%{gen}"/></a>
</body>
</html>
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
<h1>Date Tags:</h1>
<h6>Current Date In dd/MM/yyyy</h6>
<s:date name="currentDate" format="dd/MM/yyyy"/>
<h6>Current Date In yyyy/MM/dd</h6>
<s:date name="currentDate" format="yyyy/MM/dd"/>
</body>
</html>
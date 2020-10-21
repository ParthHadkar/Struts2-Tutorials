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
<h1>Employees and Contractors Merged together</h1>
<s:merge var="allEmp">
<s:param value="employees"/>
<s:param value="contractors"/>
</s:merge>
<s:iterator value="allEmp">
<s:property value="name"/>
<s:property value="dept"/><br/>
</s:iterator>
</body>
</html>
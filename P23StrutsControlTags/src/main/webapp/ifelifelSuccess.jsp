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
<s:if test="username=='Nitin'">
You have selected 'Nitin'
</s:if>
<s:elseif test="username=='Nikhil'">
You have selected 'Nikhil'
</s:elseif>
<s:else>
You have selected 'Hari'
</s:else>
</body>
</html>
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
<s:action name="generator" executeResult="true">
<h1>Rainbow:</h1>
</s:action>
<s:action name="generator" executeResult="false">
<h1>Name:</h1>
</s:action>
<s:iterator value="#attr.names">
 <s:property /><br />
</s:iterator>
<br />
<s:iterator value="#application.names">
 <s:property /><br />
</s:iterator>
</body>
</html>
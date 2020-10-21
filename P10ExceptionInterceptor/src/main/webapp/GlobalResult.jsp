<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Global Result</title>
</head>
<body>
<h1>Exception Name: <s:property value="exception"/></h1> 
<h4 style="white-space: pre-wrap;">Exception details: <s:property value="exceptionStack"/></h4>
<form>
<input type="button" value="Back" onclick="history.back()"/>
</form>
</body>
</html>
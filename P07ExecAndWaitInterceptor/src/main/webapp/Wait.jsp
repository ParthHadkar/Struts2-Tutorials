<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="0.5;url=<s:url includeParams="ALL"/>" >
<title>Processing</title>
</head>
<body>
<%--
<meta http-equiv="refresh" content="2"/>"/>
Above refresh meta will also work as long as browser supports cookie, 
by including params above we are ma


king sure that it will work even when cookies are disabled
 --%>

<h3>Your request is getting processed please wait.......</h3>

<img src="img/pocess.gif"></img>
</body>
</html>
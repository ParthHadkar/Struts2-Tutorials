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
<h1>Counters:</h1>
<s:bean name="org.apache.struts2.util.Counter" var="counter">
<s:param name="first" value="20"></s:param>
<s:param name="last" value="30"></s:param>
</s:bean>
<s:iterator value="counter"><!--%{counter} #counter %{#counter}-->
<s:property/><br/>
</s:iterator>
</body>
</html>
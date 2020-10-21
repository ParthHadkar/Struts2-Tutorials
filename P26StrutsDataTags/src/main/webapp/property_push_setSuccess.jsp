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
<h1>Property Tags:</h1>
<s:property value="environment.name"/>
<s:property value="environment.version"/>
<s:property value="operatingSystem"/>
<h1>Push Tags:</h1><!-- if you have 20 properties in the Environment
 class. Every time you need to refer to these variables you
 need to add "environment." as the prefix.  -->
<s:push value="environment">
<s:property value="name"/>
<s:property value="version"/>
</s:push>
<h1>Set Tags:</h1><!-- set tag to create a new variable -->
<s:set var="ename" value="environment.name"/>
<s:set var="eversion" value="environment.version"/>
<s:property value="ename"/>
<s:property value="eversion"/>
</body>
</html>
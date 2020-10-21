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
<h1>Welcome <s:property value="username"/><br/>
Message:- <s:text name="login.msg"></s:text><br/>
<s:property value = "getText('login.msg')" /><br/>
<s:i18n name = "com.P17Internationalization_i18nInterceptor.model">
   <s:text name = "login.msg" />
</s:i18n>
</h1>
</body>
</html>
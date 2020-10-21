<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h1><s:text name="global.title"/></h1>
<s:url var="LocaleEn" namespace="/"  action="Locale">
<s:param name="request_locale">en</s:param>
</s:url>
<s:url var="LocaleHi" namespace="/"  action="Locale">
<s:param name="request_locale">hi</s:param>
</s:url>
<s:url var="LocaleMr" namespace="/"  action="Locale">
<s:param name="request_locale">mr</s:param>
</s:url>
<s:a href="%{LocaleEn}" >English</s:a>
      <s:a href="%{LocaleHi}" >Hindi</s:a>
      <s:a href="%{LocaleMr}" >Marathi</s:a>
	<form action="Login" method="post">
	<label for="Username">Username:</label>
	<input id="Username" name="username" placeholder="<s:property value="getText('global.username')"/>" type="text"/><br/>
	<label for="Password">Password:</label>
	<input id="Password" name="Password" placeholder="<s:property value="getText('global.password')"/>" type="password"/><br/>
	<label for="LanguageCode">Language Code:</label>
	<input id="LanguageCode" name="request_locale" placeholder="<s:property value="getText('global.languageCode')"/>" type="text"/><br/> 
	<input type="submit" value="<s:property value="getText('global.signIn')"/>"/>
	</form>	
	<%-- <s:form action="Login" >
	<s:textfield id="Username" name="username" label="Username" placeholder="Username" />
	<s:password id="Password" name="Password" label="Password" placeholder="Password" />
	<s:textfield id="LanguageCode" name="request_locale" label="Language Code" placeholder="LanguageCode" />
	<s:submit value="Sign In"></s:submit>
	</s:form> --%>
</body>
</html>
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
    <s:actionerror/>
	<%--  <form action="Login" method="post">
	<label for="Username">Username:</label>
	<input id="Username" name="username" placeholder="Username" type="text"/>
	<br/>
	<label for="Password">Password:</label>
	<input id="Password" name="Password" placeholder="Password" type="password"/>
	<br/>
	<input type="submit" value="Sign In"/>
	</form>	 --%>	 
	
	 <s:form action="Login" method="post">
	<s:textfield id="Username" name="username" label="Username" placeholder="Username" />
	<s:password id="Password" name="Password" label="Password" placeholder="Password" />
	<s:submit value="Sign In"></s:submit>
	</s:form> 
</body>
</html>
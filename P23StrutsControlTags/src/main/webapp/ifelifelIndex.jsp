<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
</head>
<body>
	<form action="ifelseifelse" method="post">
	<label for = "username">Please pick a name</label><br/>
         <select name = "username" id="username">
            <option name = "Nitin">Nitin</option>
            <option name = "Nikhil">Nikhil</option>
            <option name = "Hari">Hari</option>
         </select>
	<input type="submit" value="Submit"/>
	</form>	
	<%-- <s:form action="Login" >
	<s:textfield id="Username" name="username" label="Username" placeholder="Username" />
	<s:password id="Password" name="Password" label="Password" placeholder="Password" />
	<s:submit value="Sign In"></s:submit>
	</s:form> --%>
</body>
</html>
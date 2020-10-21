<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
    <br/>
	 <form action="Register" method="post">
	<label for="Username">Username:</label>
	<input type="text" id="Username" name="Username" placeholder="Username" required="required"/><br/><br/>
	<label for="Mobileno">Mobile No:</label>
	<input type="tel" id="Mobileno" name="mobileNo" placeholder="Mobileno" required="required"/><br/><br/>
	<label for="Emailid">Email Id:</label>
	<input type="email" id="Emailid" name="emailId" placeholder="Emailid" required="required"/><br/><br/>
	<label for="Age">Age:</label>
	<input type="number" id="Age" name="age" placeholder="Age" required="required"/><br/><br/>
	<fieldset data-role="controlgroup" id="Gender">
	<legend>Gender</legend>
	<input type="radio" id="Male" name="gender"  value="Male" required="required"/>
	<label for="Male">Male</label>
	<input type="radio" id="Female" name="gender" value="Female" required="required"/>
	<label for="Female">Female</label><br/>
	</fieldset><br/><br/>
	<input type="submit" value="Sign Up"/>
	</form> 
	
	
	<%--<s:form action="Register" method="post">
	<s:textfield id="Username" name="username" label="Username" placeholder="Username" required="required"/>
	<s:textfield id="Mobileno" name="MobileNo" label="Mobileno" placeholder="Mobileno" required="required"/>
	<s:textfield id="Emailid" name="EmailId" label="Emailid" placeholder="Emailid" required="required"/>
	<s:textfield id="Age" name="Age" label="Age" placeholder="Age" required="required"/>
	<s:radio id="Gender" name="Gender" list="{'Male','Female'}" label="Gender" required="required"/>
	<s:submit value="Sign Up"/>
	</s:form>--%>
</body>
</html>
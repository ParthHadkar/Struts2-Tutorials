<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<STYLE type="text/css">  
.errorMessage{
color:red;
}  
</STYLE>  
</head>
<body>
    <br/>
    	<s:actionerror/>
    
	<form action="Register" method="post">
	<label for="username">Username:</label>
	<input type="text" id="username" name="username" value="${username}" placeholder="Username" />
	<s:fielderror fieldName="username"/>
	<br/>
	<label for="mobileNo">Mobile No:</label>
	<input type="tel" id="mobileNo" name="mobileNo" value="${mobileNo}" placeholder="Mobileno" />
	<s:fielderror fieldName="mobileNo"/>
	<br/>
	<label for="emailId">Email Id:</label>
	<input type="email" id="emailId" name="emailId" value="${emailId}" placeholder="Emailid" />
	<s:fielderror fieldName="emailId"/>
	<br/>
	<label for="age">Age:</label>
	<input type="number" id="age" name="age" placeholder="Age" value="${age}" step="1" />
	<s:fielderror fieldName="age"/>
	<br/>
	<label for="height">Height:</label>
	<input type="number" id="height" name="height" step="0.5" value="${height}" placeholder="Height"/>
	<s:fielderror fieldName="height"/>
	<br/>
	<label for="url">Url:</label>
	<input type="url" id="url" name="url" placeholder="Url" value="${url}" />
	<s:fielderror fieldName="url"/><br/>
	<br/>
	<label for="dob">Dob:</label>
	<input type="text" id="Dob" name="dob" placeholder="Dob" value="<s:property value='dob'/>" />
	<s:fielderror fieldName="dob"/><br/>
	<br/>
	<label for="password">Password:</label>
	<input type="password" id="password" name="password" value="${password}" placeholder="Password" />
	<s:fielderror fieldName="password"/><br/>
	<br/>
	<label for="cPassword">Confirm Password:</label>
	<input type="password" id="cPassword" name="cPassword" value="<s:property value='cPassword'/>" placeholder="Confirm Password"/>
	<s:fielderror fieldName="cPassword"/><br/>
	<br/>
	<fieldset data-role="controlgroup" id="gender">
	<legend>Gender</legend>
	<input type="radio" id="Male" name="gender" <%if((request.getParameter("gender")+"").equals("Male")){%>checked="checked" <%}; %> value="Male" />
	<label for="Male">Male</label>
	<input type="radio" id="Female" name="gender" <%if((request.getParameter("gender")+"").equals("Female")){%>checked="checked" <%}; %> value="Female" />
	<label for="Female">Female</label><br/>
	</fieldset>
	<s:fielderror fieldName="gender"/>
	<br/><br/>
	<s:hidden name = "secret" value = "abracadabra"/>
	<s:token />
	<input type="submit" value="Sign Up"/>
	</form>   
	
	<%-- <s:form action="Register" method="post">
	<s:textfield id="Username" name="username" label="Username" placeholder="Username" />
	<s:textfield id="Mobileno" name="MobileNo" label="Mobileno" placeholder="Mobileno" />
	<s:textfield id="Emailid" name="EmailId" label="Emailid" placeholder="Emailid" />
	<s:textfield id="Age" name="Age" label="Age" placeholder="Age" />
	<s:textfield id="Height" name="Height" label="Height" placeholder="Height" />
	<s:textfield id="Url" name="Url" label="Url" placeholder="Url" />
	<s:textfield id="Dob" name="Dob" label="Dob" placeholder="Dob" />
	<s:password id="Password" name="Password" label="Password" placeholder="Password"/>
	<s:password id="CPassword" name="CPassword" label="Confirm Password" placeholder="Confirm Password"/>
	<s:radio id="Gender" name="Gender" list="{'Male','Female'}" label="Gender" />
	<s:submit value="Sign Up"/>
	</s:form> --%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
    <%-- <%@ taglib uri="/struts-dojo-tags" prefix="d"%> for old version 2.1--%>
    <%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
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
<sj:head/>
<!-- This files are needed for AJAX Validation of XHTML Forms -->
	<script language="JavaScript" src="${pageContext.request.contextPath}/struts/utils.js" type="text/javascript"></script>
	<script language="JavaScript" src="${pageContext.request.contextPath}/struts/xhtml/validation.js" type="text/javascript"></script>
</head>
<body>
    <br/>
    	<s:actionerror/>
    
	<%--<form id="myForm" action="Register" method="post">
	<label for="username">Username:</label>
	<input type="text" id="username" name="username" value="${username}" placeholder="Username" />
	<s:fielderror fieldName="username"/>
	<br/>
	<label for="MobileNo">Mobile No:</label>
	<input type="tel" id="MobileNo" name="MobileNo" value="${MobileNo}" placeholder="Mobileno" />
	<s:fielderror fieldName="MobileNo"/>
	<br/>
	<label for="EmailId">Email Id:</label>
	<input type="email" id="EmailId" name="EmailId" value="${EmailId}" placeholder="Emailid" />
	<s:fielderror fieldName="EmailId"/>
	<br/>
	<label for="Age">Age:</label>
	<input type="number" id="Age" name="age" placeholder="Age" value="${Age}" step="1" />
	<s:fielderror fieldName="Age"/>
	<br/>
	<label for="Height">Height:</label>
	<input type="number" id="Height" name="Height" step="0.5" value="${Height}" placeholder="Height"/>
	<s:fielderror fieldName="Height"/>
	<br/>
	<label for="Url">Url:</label>
	<input type="url" id="Url" name="Url" placeholder="Url" value="${Url}" />
	<s:fielderror fieldName="Url"/><br/>
	<br/>
	<label for="Dob">Dob:</label>
	<input type="text" id="Dob" name="Dob" placeholder="Dob" value="<s:property value='Dob'/>" />
	<s:fielderror fieldName="Dob"/><br/>
	<br/>
	<label for="Password">Password:</label>
	<input type="password" id="Password" name="Password" value="${Password}" placeholder="Password" />
	<s:fielderror fieldName="Password"/><br/>
	<br/>
	<label for="cPassword">Confirm Password:</label>
	<input type="password" id="cPassword" name="cPassword" value="<s:property value='cPassword'/>" placeholder="Confirm Password"/>
	<s:fielderror fieldName="cPassword"/><br/>
	<br/>
	<fieldset data-role="controlgroup" id="Gender">
	<legend>Gender</legend>
	<input type="radio" id="Male" name="gender" <%if((request.getParameter("gender")+"").equals("Male")){%>checked="checked" <%}; %> value="Male" />
	<label for="Male">Male</label>
	<input type="radio" id="Female" name="gender" <%if((request.getParameter("gender")+"").equals("Female")){%>checked="checked" <%}; %> value="Female" />
	<label for="Female">Female</label><br/>
	</fieldset>
	<s:fielderror fieldName="gender"/>
	<br/><br/>
	<!-- <input type="submit" value="Sign Up"/> -->
	<sj:submit formIds="myForm" value="Sign Up" validate="true" type="image" src="image/register-now.jpg"/>
	</form>   --%>
	<!-- <div id="result">Submit form bellow.</div> -->
	 <s:form id="myForm" action="Register" method="post" >
	<s:textfield id="Username" name="username" label="Username" placeholder="Username" />
	<s:textfield id="Mobileno" name="MobileNo" label="Mobileno" placeholder="Mobileno" />
	<s:textfield id="Emailid" name="EmailId" label="Emailid" placeholder="Emailid" />
	<s:textfield id="Age" name="Age" label="Age" placeholder="Age" />
	<s:textfield id="Height" name="Height" label="Height" placeholder="Height" />
	<s:textfield id="Url" name="Url" label="Url" placeholder="Url" />
	<sj:datepicker id="Dob" name="Dob" label="Dob" placeholder="Dob" />
	<s:password id="Password" name="Password" label="Password" placeholder="Password"/>
	<s:password id="cPassword" name="cPassword" label="Confirm Password" placeholder="Confirm Password"/>
	<s:radio id="gender" name="gender" list="{'Male','Female'}" label="Gender" />
	<%-- <s:submit value="Sign Up" targets="result"/> --%>
	<sj:submit value="Sign Up"  validate="true" type="image" src="image/register-now.jpg"/>
	</s:form> 
</body>
</html>
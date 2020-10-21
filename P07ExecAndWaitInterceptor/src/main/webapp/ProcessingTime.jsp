<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Processing Time</title>
</head>
<body>
<br/>
<form action="ProcessingTime" method="post">
<label for="PTime">Processing Time:</label>
<input type="text" id="pTime" name="pTime" placeholder="Enter Processing Time (Seconds)" required="required"/><br/>
<input type="submit" value="Submit"/>
</form>
<%-- <s:form action="ProcessingTime" method="post">
<s:textfield id="pTime" name="pTime" label="Processing Time" placeholder="Enter Processing Time (Seconds)" required="required"/>
<s:submit value="Submit"/>
</s:form> --%>
</body>
</html>
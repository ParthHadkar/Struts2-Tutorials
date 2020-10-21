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
<h1>The colours of rainbow:</h1>
<s:generator separator="," val="%{'Violet,Indigo,Blue,
         Green,Yellow,Orange,Red '}" count = "7"><!-- -->
         <s:iterator>
         <s:property/><br/>
         </s:iterator>
         </s:generator>
</body>
</html>
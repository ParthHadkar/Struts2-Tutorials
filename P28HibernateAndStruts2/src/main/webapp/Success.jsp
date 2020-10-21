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
<table>
<thead>
<tr>
<th>Id</th><th>username</th><th>mobileNo</th><th>emailId</th><th>age</th><th>gender</th>
</tr>
</thead>
<tbody>
<s:iterator value="usersList">
<tr>
<td><s:property value="username"/></td>
<td><s:property value="mobileNo"/></td>
<td><s:property value="emailId"/></td>
<td><s:property value="age"/></td>
<td><s:property value="gender"/></td>
</tr>
</s:iterator>
</tbody>
</table>
</body>
</html>
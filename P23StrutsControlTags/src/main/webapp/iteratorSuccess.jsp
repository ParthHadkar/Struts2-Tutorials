<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
</head>
<body>
<h1>Employee unsorted</h1>
<s:iterator value="employees">
<s:property value="name"/>
<s:property value="dept"/><br/>
</s:iterator>
<h1>Employee sorted</h1>
<s:bean name="com.P23StrutsControlTags.model.iterator.DepartmentComparator" 
var="departmentComparator"/>
<s:sort comparator="departmentComparator" source="employees" >
<s:iterator>
<s:property value="name"/>
<s:property value="dept"/><br/>
</s:iterator>
</s:sort>
<h1>Employees working in Recruitment department </h1>
<s:subset decider="recruitmentDecider" source="employees">
<s:iterator>
<s:property value="name"/>
<s:property value="dept"/><br/>
</s:iterator>
</s:subset>
<h1>Employees working from start index to length of the subset </h1>
<s:subset start="1" count="3" source="employees">
<s:iterator>
<s:property value="name"/>
<s:property value="dept"/><br/>
</s:iterator>
</s:subset>
</body>
</html>
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
<h1>Text Tags:</h1>
<s:i18n name="com.P26StrutsDataTags.model.text.User">
<s:text name="user.success"></s:text><br/>
<s:text name="user.xyz">Message doesn't exists</s:text><br/>
<s:text name="user.msg.param">
<s:param>ZARA</s:param>
</s:text><br/>
</s:i18n>
<s:text name="user.success"></s:text>
<s:property value="getText('user.success')"/>
</body>
</html>
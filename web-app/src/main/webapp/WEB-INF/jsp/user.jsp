<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/elements/_setLocale.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
</head>
<body>
	User

	<form name="userInfo" method="POST" action="controller">
		<input type="hidden" name="command" value="userInfo"> 
		<input type="text" name="id" value="1"> 
		<input	type="submit" value="UserInfo">
	</form>

</body>
</html>
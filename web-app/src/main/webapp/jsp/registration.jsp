<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:if
	test="${sessionScope.locale == 'locale_ru_RU' or empty sessionScope.locale}">
	<fmt:setBundle basename="locale_ru_RU" />
</c:if>
<c:if test="${sessionScope.locale == 'locale_en_US'}">
	<fmt:setBundle basename="locale_en_US" />
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="index.title" /></title>
</head>
<body>
	<%@ include file="/jsp/elements/_header.jsp"%>
	<%@ include file="/jsp/elements/_auth.jsp"%>

	<form name="registrationForm" method="POST" action="controller">
		<input type="hidden" name="command" value="registration" />
		 Введите
		ваши данные:<br />
		<table>
			<tr>
				<td>Логин:</td>
				<td><input type="text" name="login" value="" size="20" /></td>
			</tr>
			<tr>
				<td>Пароль:</td>
				<td><input type="password" name="pass" value="" size="20" /></td>
			</tr>
			<tr>
				<td>Контактная информация:</td>
				<td><input type="text" name="user_info" value="" size="20" /></td>
			</tr>
			<tr>
			<td></td>
			<td><input type="submit" value="Зарегистрировать"></td>
		</table>
		</form>
			${operationMessage} 
			${errorUserExsists} <br />

		<c:import url="/jsp/elements${sideBar}" />
</body>
</html>
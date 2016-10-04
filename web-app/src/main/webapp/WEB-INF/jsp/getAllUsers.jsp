<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if
        test="${sessionScope.locale == 'locale_ru_RU' or empty sessionScope.locale}">
    <fmt:setBundle basename="locale_ru_RU"/>
</c:if>
<c:if test="${sessionScope.locale == 'locale_en_US'}">
    <fmt:setBundle basename="locale_en_US"/>
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title><fmt:message key="index.title"/></title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/elements/_header.jsp" %>
<%@ include file="/WEB-INF/jsp/elements/_auth.jsp" %>
<p>access Level ${accessLevel}</p>

Get All Users
<table border="1">
    <tr>
        <td>ID</td>
        <td>Login</td>
        <td>Contact Info</td>
    </tr>
    <c:forEach items="${users}" var="item">
        <tr>
            <td>${item.id}</td>
            <td><a href="userInfo?userId=${item.id}">${item.login}</a></td>
            <td>${item.userInfo}</td>
        </tr>
    </c:forEach>
</table>
<c:import url="/WEB-INF/jsp/elements${sideBar}"/>
</body>
</html>
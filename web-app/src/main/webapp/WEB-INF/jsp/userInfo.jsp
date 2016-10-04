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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><fmt:message key="index.title" /></title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/elements/_header.jsp"%>
<%@ include file="/WEB-INF/jsp/elements/_auth.jsp"%>
<p>access Level ${accessLevel}</p>

UserInfo

Old one
<h3>${user_info.login} </h3>
<p>${user_info.userInfo}</p>

Requests
<table border="1">
    <tr>
        <td> Id </td>
        <td> Date checkIn </td>
        <td> Date checkOut </td>
        <td> Adults </td>
        <td> Invoice </td>

    <c:forEach items="${user_info.requests}" var="item">
    </tr>
    <td>${item.id}</td>
    <td>${item.checkIn}</td>
    <td>${item.checkOut}</td>
    <td>${item.adults}</td>
    <td><c:choose>
        <c:when test="${item.invoice.id=='0'}">
            <input type="submit" value="Выставить счет"/>
        </c:when>
        <c:otherwise>
            № ${item.invoice.id} - ${item.invoice.totalPrice} ye - ${item.invoice.paid == 'true' ? "Оплачено" : "Не оплачено"}
        </c:otherwise>
    </c:choose></td>
    <tr>
    </c:forEach>


    </tr>
</table>


<c:import url="/WEB-INF/jsp/elements${sideBar}" />
</body>
</html>
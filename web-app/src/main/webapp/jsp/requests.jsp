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
<%@ include file="/jsp/elements/_header.jsp" %>
<%@ include file="/jsp/elements/_auth.jsp" %>
<p>access Level ${accessLevel}</p>

Requests
<table border="1">
    <tr>
        <td>ID</td>
        <c:if test="${accessLevel == 'ADMIN'}">
            <td>User</td>
        </c:if>
        <td>Check in</td>
        <td>Check out</td>
        <td>Adults</td>
        <td>Invoice</td>
    </tr>

    <c:forEach items="${requests}" var="item">

        <form name="toInvoiceForm" method="post" action="controller">
            <input type="hidden" name="command" value="toInvoice"/>
            <tr>
                <td>${item.id}</td>

                <c:if test="${accessLevel == 'ADMIN'}">
                    <td><a href="controller?command=userInfo&userId=${item.user.id}"> ${item.user.login}</a></td>
                </c:if>
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
            </tr>
        </form>
    </c:forEach>
</table>
<c:import url="/jsp/elements${sideBar}"/>
</body>
</html>
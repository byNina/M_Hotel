<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/WEB-INF/jsp/elements/_setLocale.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title><fmt:message key="index.title"/></title>
    <link
            href="http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300"
            rel="stylesheet" type="text/css"/>
    <link href="${pageContext.servletContext.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"
          media="screen"/>
</head>
<body>
<div class="wrapper">
    <div class="header">
        <%@ include file="/WEB-INF/jsp/elements/_header.jsp" %>
    </div> <!-- end of header -->
    <div id="wrapper">
        <div id="splash" class="container">
            <span><fmt:message key="body.title"/></span>

        </div>

        <div id="page" class="container">
            <div id="content">
                <div class="post">
                    <h2 class="title">
                        <a href="#"><fmt:message key="body.greetings"/> </a>
                    </h2>
                    <div class="entry">


                        <%@ include file="/WEB-INF/jsp/elements/_pagination.jsp" %>
                        Requests
                        <table border="1">
                            <tr>
                                <th>ID</th>
                                <c:if test="${accessLevel == 'ADMIN'}">
                                    <th>User</th>
                                </c:if>
                                <th>Check in</th>
                                <th>Check out</th>
                                <th>Adults</th>
                                <th>Invoice</th>
                            </tr>

                            <c:forEach items="${requests}" var="item">

                                <form name="toInvoiceForm" method="post" action="invoiceForm">
                                    <tr>
                                        <td>${item.id}</td>

                                        <c:if test="${accessLevel == 'ADMIN'}">
                                            <td><a href="userInfo?userId=${item.user.id}"> ${item.user.login}</a></td>
                                        </c:if>
                                        <td><fmt:formatDate value='${item.checkIn}' pattern='yyyy-MM-dd'/></td>
                                        <td><fmt:formatDate value='${item.checkOut}' pattern='yyyy-MM-dd'/></td>
                                        <td>${item.adults}</td>
                                        <td><c:choose>
                                            <c:when test="${empty item.invoice.id}">
                                                <c:choose>
                                                <c:when test="${accessLevel == 'ADMIN'}">
                                                    <input type="submit" value="Выставить счет"/>
                                                </c:when>
                                                <c:otherwise>
                                                    Запрос находиться в обработке
                                                </c:otherwise>
                                                </c:choose>
                                            </c:when>
                                            <c:otherwise>
                                                № ${item.invoice.id} - ${item.invoice.totalPrice} ye - ${item.invoice.paid == 'true' ? "Оплачено" : "Не оплачено"}
                                            </c:otherwise>
                                        </c:choose></td>
                                    </tr>
                                </form>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
            <%--<div style="clear: both;">&nbsp;</div>--%>
            <div id="sidebar">

                <fmt:message key="main.intro"/>

                <c:import url="/WEB-INF/jsp/elements${sideBar}"/>
                <p></p>
                <form name="loginForm2" method="POST" action="test">
                    <input type="submit" value="Тест контроллера"/>
                </form>
            </div>
            <!-- end #sidebar -->
        </div>
        <!-- end #content -->

        <div style="clear: both;">&nbsp;</div>
    </div>
    <!-- end #page -->
</div>

<div id="footer">
    <p>
        © 2016 .
    </p>
</div>
<!-- end #footer -->
</body>
</html>
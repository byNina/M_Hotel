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

                                <form name="toInvoiceForm" method="post" action="toInvoice">
                                    <tr>
                                        <td>${item.id}</td>

                                        <c:if test="${accessLevel == 'ADMIN'}">
                                            <td><a href="userInfo?userId=${item.user.id}"> ${item.user.login}</a></td>
                                        </c:if>
                                        <td>${item.checkIn}</td>
                                        <td>${item.checkOut}</td>
                                        <td>${item.adults}</td>
                                        <td><c:choose>
                                            <c:when test="${empty item.invoice.id}">
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
        © 2016 </a>.
    </p>
</div>
<!-- end #footer -->
</body>
</html>
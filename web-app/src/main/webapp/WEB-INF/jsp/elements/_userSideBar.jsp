<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/WEB-INF/jsp/elements/_setLocale.jsp" %>

<div>
    <h2>
        <fmt:message key="side.panel.user.intro"/>
    </h2>
    <ul class="list-style1">
        <li><a href="${pageContext.servletContext.contextPath}/users/showMyRequests"> <fmt:message
                key="side.panel.user.showMyRequests"/></a></li>
        <li><a href="${pageContext.servletContext.contextPath}/users/gotonewrequestcreation"><fmt:message
                key="side.panel.user.createNewRequest"/></a></li>
    </ul>
    <hr/>
</div>

<!-- end #sidebar -->

<c:import url="/WEB-INF/jsp/elements/_guestSideBar.jsp"/>
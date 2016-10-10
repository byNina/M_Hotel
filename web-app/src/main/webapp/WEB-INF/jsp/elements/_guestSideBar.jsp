<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/WEB-INF/jsp/elements/_setLocale.jsp" %>

<div>
    <h2>
        <fmt:message key="side.panel.guest.intro"/>
    </h2>
    <ul class="list-style1">
        <li><a href="${pageContext.servletContext.contextPath}/hotelInfo"><fmt:message
                key="side.panel.guest.aboutHotel"/></a></li>
        <li><a href="${pageContext.servletContext.contextPath}/showAllRooms"><fmt:message
                key="side.panel.guest.showApartments"/></a></li>
    </ul>
    <hr/>
</div>

<!-- end #sidebar -->
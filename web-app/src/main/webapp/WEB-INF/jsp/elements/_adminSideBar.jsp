<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <h2>
        AdminSideBar
    </h2>
    <ul class="list-style1">
        <li><a href="showRequests">Показать все заявки</a></li>
        <li><a href="${pageContext.request.contextPath}/getAllUsers">Показать всех пользователей</a></li>
        <hr/>
    </ul>
</div>


<c:import url="/WEB-INF/jsp/elements/_guestSideBar.jsp"/>
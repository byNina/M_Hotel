<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>
AdminSideBar
</h2>

<p><a href="controller?command=showRequests">Показать все заявки</a></p>
<p><a href="${pageContext.request.contextPath}/getAllUsers">Показать всех пользователей</a></p>


<c:import url="/jsp/elements/_guestSideBar.jsp"/>
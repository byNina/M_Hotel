<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>
User Side Bar
</h2>
<p><a href="controller?command=showMyRequests">Показать мои заявки</a></p>
<p><a href="controller?command=gotonewrequestcreation">Оформить новую заявку</a></p>
<hr/>

<c:import url="/jsp/elements/_guestSideBar.jsp"/>
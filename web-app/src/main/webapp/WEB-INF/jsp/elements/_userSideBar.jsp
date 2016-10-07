<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <h2>
        User Side Bar
    </h2>
    <ul class="list-style1">
        <li><a href="showMyRequests">Показать мои заявки</a></li>
        <li><a href="gotonewrequestcreation">Оформить новую заявку</a></li>
        <hr/>
    </ul>
</div>

<!-- end #sidebar -->

<c:import url="/WEB-INF/jsp/elements/_guestSideBar.jsp"/>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="index.title" /></title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/elements/_header.jsp"%>
	<%@ include file="/WEB-INF/jsp/elements/_auth.jsp"%>
	<p>access Level ${accessLevel}</p>
	<c:import url="/WEB-INF/jsp/elements${sideBar}" />

	HotelInfo

	<h2 class="title">
		<a href="#"><fmt:message key="body.greetings" /> </a>
	</h2>

	<p>
		<fmt:message key="body.paragraf1" />
	</p>
	<p>
		<fmt:message key="body.paragraf2" />
	</p>
	<p>
		<fmt:message key="body.paragraf3" />
	</p>
	<p>
		<fmt:message key="body.paragraf4" />
	</p>
	<p>
		<fmt:message key="body.paragraf5" />
	</p>
	<p>
		<fmt:message key="body.paragraf6" />
	</p>
	<!-- end #content -->
</body>
</html>
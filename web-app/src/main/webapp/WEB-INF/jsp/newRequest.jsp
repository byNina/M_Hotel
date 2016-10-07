<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
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
                        <script type="text/javascript" src="js/validation.js"></script>
                        New Request
                        <form name="requestForm" method="POST" action="controller">
                            <input type="hidden" name="command" value="createnewrequest"/>

                            Введите ваши данные:<br/>
                            <table>
                                <tr>
                                    <td>Дата заселения:</td>
                                    <td><input id="Date1" type="text" name="checkIn" onchange="validateDate()" value=""
                                               size="20" pattern="[0-9]{2}.[0-9]{2}.[0-9]{4}" placeholder="DD.mm.yyyy"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Дата выселения:</td>
                                    <td><input id="Date2" type="text" name="checkOut" value="" size="20"
                                               pattern="[0-9]{2}.[0-9]{2}.[0-9]{4}" placeholder="DD.mm.yyyy"/></td>
                                </tr>
                                <tr>
                                    <td>Количество взрослых:</td>
                                    <td><input type="text" name="adults" value="" size="20" pattern="[0-9]"/></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type="submit" value="Сформировать заявку"></td>
                            </table>
                        </form>

                        </form>
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
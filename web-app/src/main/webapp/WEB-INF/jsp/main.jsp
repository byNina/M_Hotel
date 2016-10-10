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


                        <img src="${pageContext.servletContext.contextPath}/resources/images/page1_img1.jpg" alt>
                        <h3> Rooms</h3>
                        <em> comfortable solution</em>
                        <p> Our fully equipped superior rooms offer functionality and comfort at the same time in
                            which include a king size bed or twin beds. In the 20 m² area of superior.</p>

                        <div class="icons i1"></div>
                        <a href="" class="btn">
                            "Read More"
                        </a>

                        <br>
                        <br>
                        <br>
                        <img src="${pageContext.servletContext.contextPath}/resources/images/page1_img2.jpg" alt>
                        <h3> Our Service</h3>
                        <em> breakfast included</em>
                        <p> The terrace restaurant where the breakfast is served has a panoramic view of Hippodrome
                            Square, Blue Mosque, St. Sophie and the Sea of Marmara.</p>

                        <div class="icons"></div>
                        <a href="" class="btn">
                            "Read More"
                        </a>
                        <br>
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
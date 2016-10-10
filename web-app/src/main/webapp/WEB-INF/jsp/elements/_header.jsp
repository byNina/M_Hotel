<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</form>
<div id="header-wrapper">
    <div id="header" class="container">
        <div id="logo">
            <h1>
                <a href="${pageContext.servletContext.contextPath}/main">Solaris hotel
                          </a>
            </h1>
            <p>
                <fmt:message key="index.title"/>

                </form>
            </p>

        </div>
        <div id="menu">
            <span style="width: 130px; vertical-align: middle;">
                <div class="locale_bar_frame">
                    <div class="locale_bar">
                        <form action="${pageContext.servletContext.contextPath}/setLang" method="get">
                            <input type="image" src="${pageContext.servletContext.contextPath}/resources/images/GB.png" name="lang" value="en_US" alt="en_US"/>
                            <input type="image" src="${pageContext.servletContext.contextPath}/resources/images/RU.png"
                                    name="lang" value="ru_RU" alt="ru_RU"/>
                        </form>
                    </div>
                </div>
            </span>
            <ul>
                <%@include file="../elements/_auth.jsp" %>
            </ul>
        </div>
    </div>
    <div id="banner" class="container">
        <div class="image-style">
            <img src="${pageContext.servletContext.contextPath}/resources/images/img03.jpg" width="970" height="320"
                 alt=""/>
        </div>
    </div>
</div>


	
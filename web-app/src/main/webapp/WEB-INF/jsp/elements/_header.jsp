<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</form>
<div id="header-wrapper">
    <div id="header" class="container">
        <div id="logo">
            <h1>
                <a href="#">Solaris </a>
            </h1>
            <p>
                <fmt:message key="index.title"/>
                </a>
                </form>
            </p>

        </div>
        <div id="menu">
            <td style="width: 130px; vertical-align: middle;">
                <div class="locale_bar_frame">
                    <div class="locale_bar">
                        <form action="setLang" method="post">
                            <input type="image" src="${pageContext.servletContext.contextPath}/resources/images/GB.png"
                                   alt="en_US" name="lang" value="en_US" id="EnLangButton"/>
                            <input type="image" src="${pageContext.servletContext.contextPath}/resources/images/RU.png"
                                   alt="ru_RU" name="lang" value="ru_RU" id="RuLangButton"/>
                        </form>
                    </div>
                </div>
            </td>
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


	
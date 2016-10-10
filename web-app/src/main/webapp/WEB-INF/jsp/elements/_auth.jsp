<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/validation.js"></script>

<form name="loginForm" method="POST" onsubmit="return validateForm()"
      action="${pageContext.servletContext.contextPath}/users/login">
    <fmt:message key="auth.login"/>
    <br/> <input type="text" name="login" value=""/><br/>
    <fmt:message key="auth.password"/>
    <br/> <input type="password" name="pass" value=""/>

    <table style="width: 173px;">
        <tr>
            <td>
                <input type="image"
                       src="${pageContext.servletContext.contextPath}/resources/images/login-button-png-18028.png"
                       alt="Log in" style="margin-top: 5px"/>
            </td>
            <td><a href="${pageContext.servletContext.contextPath}/registration"><fmt:message
                    key="main.registration"/></a></td>
        </tr>
    </table>
</form>
<span style="color: #ce91a6; font-size: 14px">
                <table style="width: 173px; text-align: right;">
                    <tr>
                        <th>
                            Welcome
                <c:if test="${user ne null}">
                    ${user.login}
                </c:if>
                        </th>
                        <th>
                              <c:if test="${user ne null}">
                                  <a href="${pageContext.servletContext.contextPath}/logout"
                                     style="    height: 22px;"><fmt:message key="main.logout"/></a>
                              </c:if>
                        </th>

                    </tr>
                    <tr>
                        <th colspan="2">
                            Your access Level - ${accessLevel}
                        </th>

                    </tr>
                </table>
</span>







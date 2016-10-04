<script type="text/javascript" src="js/validation.js"></script>


<form name="loginForm" method="POST" onsubmit="return validateForm()"
      action="/users/login">
    <fmt:message key="auth.login"/>
    <br/> <input type="text" name="login" value=""/><br/>
    <fmt:message key="auth.password"/>
    <br/> <input type="password" name="pass" value=""/> <input
        type="submit" value="Log in" style="margin-top: 15px"/>
</form>

<%--<sf:form method="POST" action="login" modelAttribute="user">--%>
<%--<fieldset>--%>
<%--<label for="login">Login</label>--%>
<%--<sf:input path="login" type="text" id="login"/>--%>
<%--<label for="password">Password</label>--%>
<%--<sf:input path="password" type="text" id="password"/>--%>
<%--</fieldset>--%>
<%--</sf:form>--%>


<a href="registration"><fmt:message key="main.regestration"/></a>
<a href="logout"><fmt:message key="main.logout"/></a>
<hr/>
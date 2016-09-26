<script type="text/javascript" src="js/validation.js"></script>
<form name="loginForm" method="POST" onsubmit="return validateForm()"
	action="controller">
	<input type="hidden" name="command" value="login" />
	<fmt:message key="auth.login" />
	<br /> <input type="text" name="login" value="" /><br />
	<fmt:message key="auth.password" />
	<br /> <input type="password" name="pass" value="" /> <input
		type="submit" value="Log in" style="margin-top: 15px" />
</form>
<a href="controller?command=gotoregistration"><fmt:message
		key="main.regestration" /></a>
<a href="controller?command=logout"><fmt:message key="main.logout" /></a>
<hr />
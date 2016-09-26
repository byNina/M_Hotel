<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="controller" method="post">
	<input type="hidden" name="command" value="lang" /> <input
		type="submit" name="lang" value="en_US" id="EnLangButton" /> <input
		type="submit" name="lang" value="ru_RU" id="RuLangButton" />
</form>

<h3>Welcome 
<c:if test="${user ne null}">
${user.login}
</c:if>

</h3>
	<hr />
	
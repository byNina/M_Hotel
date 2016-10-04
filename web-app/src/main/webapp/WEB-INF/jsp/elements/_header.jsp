<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="controller" method="post">
	<input type="hidden" name="command" value="lang" /> <input
		type="submit" name="lang" value="en_US" id="EnLangButton" /> <input
		type="submit" name="lang" value="ru_RU" id="RuLangButton" />
</form>
<div id="header-wrapper">
	<div id="header" class="container">
		<div id="logo">
			<h1>
				<a href="#">Solaris </a>
			</h1>
			<p>
				<fmt:message key="index.title" />
				</a>
			</p>
		</div>
		<div id="menu">
			<td style="width: 130px; vertical-align: middle;">
				<div class="locale_bar_frame">
					<div class="locale_bar">
						<form action="action" method="post">
							<input type="hidden" name="an" value="lang" /> <input
								type="submit" name="av" value="en_US" id="EnLangButton" /> <input
								type="submit" name="av" value="ru_RU" id="RuLangButton" />
						</form>
					</div>
				</div>
			</td>
			<ul>
				<%@include file="../elements/_auth.jsp"%>

			</ul>
		</div>
	</div>
	<div id="banner" class="container">
		<div class="image-style">
			<img src="images/img03.jpg" width="970" height="320" alt="" />
		</div>
	</div>
</div>
<h3>Welcome 
<c:if test="${user ne null}">
${user.login}
</c:if>

</h3>
	<hr />
	
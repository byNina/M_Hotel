<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<script type="text/javascript" src="js/validation.js"></script>
New Request
<form name="requestForm" method="POST"  action="controller">
<input type="hidden" name="command" value="createnewrequest" />

 Введите	ваши данные:<br />
		<table>
			<tr>
				<td>Дата заселения:</td>
				<td><input id="Date1" type="text" name="checkIn" onchange="validateDate()" value="" size="20" pattern="[0-9]{2}.[0-9]{2}.[0-9]{4}" placeholder="DD.mm.yyyy"/></td>
			</tr>
			<tr>
				<td>Дата выселения:</td>
				<td><input id="Date2" type="text" name="checkOut" value="" size="20" pattern="[0-9]{2}.[0-9]{2}.[0-9]{4}" placeholder="DD.mm.yyyy"/></td>
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
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>忘記密碼</title>
</head>
<body>
	<center>
		<form action="newPass" method="post">
				<tr>
					<td>帳號 <input type="text" name="acc"></td>
				</tr>
				<br>
				<br> <input type="submit" name="submit" value="補發新密碼"> <br>
			</form>
	</center>
</body>
</html>
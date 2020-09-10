<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Spring 4 MVC - HelloWorld Index Page</title>
</head>
<body>

	<center>
		<h3>
			<form action="hello" method="post">
				<tr>
					<td>帳號 <input type="text" name="acc"></td>
				</tr>
				<br>
				<tr>
					<td>密碼 <input type="text" name="password"></td>
				</tr>
				<br> <input type="submit" name="submit" value="登入"> <br>
			</form>
			<form action="singin" method="post">
				<input type="submit" name="singin" value="註冊">
			</form>
			<form action="newPass" method="post">
				<input type="submit" name="newPass" value="忘記密碼">
			</form>
		</h3>
	</center>
</body>
</html>

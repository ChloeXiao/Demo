<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SSH</title>
</head>
<body>
	<center>
		<h3>
			<s:form action="login" method="post">
				<table>
					<tr>
						<td><s:textfield name="loginBean.acc"/>帳號</td>
					</tr>
					<br />
					<tr>
						<td><s:textfield name="loginBean.password"/>密碼</td>
					</tr>

				</table>
				<br />
				<s:submit value="登入"></s:submit>
				<br />
			</s:form>
			<s:form action="singin">
				<s:submit value="註冊"></s:submit>
			</s:form>
			<s:form action="newPass">
				<s:submit value="忘記密碼"></s:submit>
			</s:form>
		</h3>
	</center>
</body>
</html>

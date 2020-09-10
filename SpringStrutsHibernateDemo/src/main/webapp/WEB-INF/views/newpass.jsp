<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>忘記密碼</title>
</head>
<body>
	<center>
		<s:form action="newPass" method="post">
				<tr>
					<td>帳號 <s:textfield name="acc"/></td>
				</tr>
				<br/> <s:submit value="補發新密碼"></s:submit> <br/>
			</s:form>
	</center>
</body>
</html>
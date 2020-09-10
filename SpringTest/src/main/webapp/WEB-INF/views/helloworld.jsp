<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User Data</title>
</head>
<body>
	<center>
		<h2>個人資料</h2>
		<c:forEach var="stu" items="${user}">
		<c:out value="ID / UserName / Email "></c:out>
		<br>
			<c:out
				value="${stu.id}  ${stu.username}  ${stu.email} ">
			</c:out>
			<br>
		</c:forEach>
	</center>
</body>
</html>
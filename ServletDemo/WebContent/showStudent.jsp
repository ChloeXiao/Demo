<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>�ǥ͸��</title>
</head>
<body>
	<tr>
		<td>�Ǹ�    �m�W    �ͤ�     �ʧO     Email</td>
	</tr>
	<br>
	<c:forEach var="stu" items="${studentList}">
		<c:out
			value="${stu.sno}  ${stu.sname}  ${stu.sbday}  ${stu.ssex}  ${stu.smail}  ${stu.spwd}">
		</c:out>
		<br>
	</c:forEach>

</body>
</html>
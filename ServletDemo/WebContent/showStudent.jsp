<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>學生資料</title>
</head>
<body>
	<tr>
		<td>學號    姓名    生日     性別     Email</td>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增</title>
</head>
<body>
	<form action="ServletDemo" method="post">
		<tr>
			<td>請輸入要產生學生資料的筆數:<input type="text" name="count"></td>
		</tr>
		<br>
		<tr>
			<td><input type="submit" name="insert" value="insert"></td>
		</tr>
		<br> 
		<c:if test="${param.insert != null && param.count.isEmpty()}">
			<c:out value="${error}" />
		</c:if>
		<c:if test="${param.insert == 'insert' && !param.count.isEmpty()}">
			<span style="color: green"> <c:out
					value=" 成功  ${successCount}  筆" />
			</span>
			<br>
			<span style="color: red"> <c:out value="失敗  ${failCount}  筆" />
			</span>
			<br>
			<td><input type="submit" name="select" value="查詢學生資料"></td>
		</c:if>

	</form>

</body>
</html>
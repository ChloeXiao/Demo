<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Sing in</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#check').click(function() {
			var accId = $("#singIn.acc").val();
			alert("acc" + accId);
			$.ajax({
				type : 'GET',
				url : 'checkId',
				dataType : 'text',
				data : {
					"singIn.acc" : accId
				},
				success : function(data) {
					if (data == 'true') {
						alert('帳號已存在，請重新檢查');
						$('#check').attr("hidden", false);
						$('#btn').attr("hidden", true);
					} else {
						alert('檢查成功');
						$('#btn').attr("hidden", false);
						$('#check').attr("hidden", true);
					}
				},
				error : function() {
					alert("fail");
				}
			});
		})
	});
	$(document).ready(function() {
		$('#checke').click(function() {
			var email = $("#email").val();
			alert("email" + email);
			$.ajax({
				type : 'GET',
				url : 'checkEmail',
				dataType : 'text',
				data : {
					email : email
				},
				success : function(data) {
					if (data == 'true') {
						alert('檢查成功');
						$('#checke').attr("hidden", true);
						$('#btn').attr("hidden", false);
					} else {
						alert('email格式錯誤');
						$('#btn').attr("hidden", true);
						$('#checke').attr("hidden", false);
					}
				},
				error : function() {
					alert("fail");
				}
			});
		})
	});
</script>
</head>
<body>
	<center>
		<s:form action="singin" method="post">
				<tr>
					<td>帳號<s:textfield name="singIn.acc" /></td>
				</tr>
				<br />
				<tr>
					<td>密碼 <s:textfield name="singIn.password" /></td>
				</tr>
				<br />
				<tr>
					<td>姓名 <s:textfield name="singIn.userName" /></td>
				</tr>
				<br />
				<tr>
					<td>E-Mail <s:textfield name="singIn.email" /></td>
				</tr>
			<br>
			<s:submit type="submit" name="btn" value="註冊" />
		</s:form>
		<s:submit type="button" name="check" value="檢查ID" />
		<br>
		<s:submit type="button" name="checke" value="檢查Email" />
		<br>
	</center>
</body>
</html>


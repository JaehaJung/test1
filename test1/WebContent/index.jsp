<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Yongin LMS</h3>
	
	<form action ="login.do" method = "post">
		ID <input type = "text" name ="id" /><br>
		PASSWORD <input type = "password" name ="pwd" /><br>
		<label><input type = "radio" name = "type" value = "p" >professor</label>
		<label><input type = "radio" name = "type" value = "s" >student</label>	
		<input type = "submit" value = "login"/>
	</form>
</body>
</html>
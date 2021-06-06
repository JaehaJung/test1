<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Enroll Subject</h3>
	
	<form action ="enroll.do" method = "post">
		subject<br>
		ID <input type = "text" name ="id" /><br>
		Title <input type = "text" name ="subject" /><br>
		# of Student <input type = "text" name ="snum" /><br>
		<input type = "submit" value = "Enroll"/>
	</form>
</body>
</html>
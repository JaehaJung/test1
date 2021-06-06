<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="St_subject.do" method = "post">
    <input type="text" name="userid" value="<%=(String) session.getAttribute("id")%>">
    </form>
</form>
</body>
</html>
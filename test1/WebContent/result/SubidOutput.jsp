<%@page import="test1.vo.EnrollVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  ArrayList<EnrollVO> list = (ArrayList<EnrollVO>) request.getAttribute("list"); 
    if(!list.isEmpty()) {  %>
	   <table border="1">
	   		<tr><th>id</th><th>name</th></tr>
			
			<%   for(int i=0; i<list.size(); i++){   
				EnrollVO subject = list.get(i);   %>
			       
			        <tr><td><%=subject.getSubject() %></td>
			            <td><%=subject.getStudent() %></td>
			       </tr>
			       
			<%   }
       }else{
    	   out.print("<h3>등록한 학생이 없습니다.</h3>");
       }
	%>
	  </table>
</body>
</html>
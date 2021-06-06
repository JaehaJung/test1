<%@page import="test1.vo.SubjectVO"%>
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
<%  ArrayList<SubjectVO> list = (ArrayList<SubjectVO>) request.getAttribute("list"); 
    if(!list.isEmpty()) {  %>
	   <table border="1">
	   		<tr><th>ID</th><th>과목 명</th></tr>
			
			<%   for(int i=0; i<list.size(); i++){   
			       SubjectVO subject = list.get(i);   %>
			       
			        <tr><td><%=subject.getId() %></td>
			            <td><%=subject.getName() %></td>
			       </tr>
			 
		<form action ="subenroll.do" method = "post">
		<input type="text" name="userid" value="<%=(String) session.getAttribute("id")%>">
		<input type="text" name="subid" value="<%=subject.getId()%>">
		<input type = "submit" value = "enroll"/>
	</form>
			<%   }
       }else{
    	   out.print("<h3>등록된 과목 정보가 없습니다.</h3>");
       }
	%>
	  </table>
</body>
</html>
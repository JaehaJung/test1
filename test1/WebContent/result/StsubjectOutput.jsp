<%@page import="test1.vo.EnrollVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>과목 정보</title>
</head>
<body>

<%  ArrayList<EnrollVO> list = (ArrayList<EnrollVO>) request.getAttribute("list"); 
    if(!list.isEmpty()) {  %>
	   <table border="1">
	   		<tr><th>subject</th><th>Student</th></tr>
			
			<%   for(int i=0; i<list.size(); i++){   
				EnrollVO subject = list.get(i);   %>
			       
			        <tr><td><%=subject.getSubject() %></td>
			            <td><%=subject.getStudent() %></td>
			       </tr>
			       
			<%   }
       }else{
    	   out.print("<h3>등록된 과목 정보가 없습니다.</h3>");
       }
	%>
	  </table>
	
 
</body>
</html>
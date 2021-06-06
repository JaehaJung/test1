<%@page import="test1.vo.SubjectVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>과목 정보</title>
</head>
<body>

<%  ArrayList<SubjectVO> list = (ArrayList<SubjectVO>) request.getAttribute("list"); 
    if(!list.isEmpty()) {  %>
	   <table border="1">
	   		<tr><th>ID</th><th>과목 명</th><th>학생 수</th><th>교수</th></tr>
			
			<%   for(int i=0; i<list.size(); i++){   
			       SubjectVO subject = list.get(i);   %>
			        <tr><td>
			       <form action ="subid.do" method = "post">
				    <input type="text" name="subid" value="<%=subject.getId() %>">
				    </form>
			        <%=subject.getId() %></td>
			            <td><%=subject.getName() %></td>
			            <td><%=subject.getCount() %></td>
			            <td><%=subject.getProf() %></td>
			       </tr>
			       
			<%   }
       }else{
    	   out.print("<h3>등록된 과목 정보가 없습니다.</h3>");
       }
	%>
	  </table>
	
 
</body>
</html>
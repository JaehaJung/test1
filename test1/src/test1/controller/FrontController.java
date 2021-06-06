package test1.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {
	HashMap<String, Controller> map = null; // 해쉬 맵 정의
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map = new HashMap<String, Controller>(); // 해쉬 맵 객체 생성
		map.put("/login.do", new LoginController()); 
		map.put("/enroll.do", new EnrollController());
		map.put("/subject.do", new SubjectController());
		map.put("/St_enroll.do", new StEnrollController());
		map.put("/subenroll.do", new SubEnrollController());
		map.put("/St_subject.do", new StsubjectController());
		map.put("/subid.do", new SubidController());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uri = req.getRequestURI();  // uri의 뒷부분 가져오기 
		String contextPath = req.getContextPath(); // test1 ~~~~
		String path = uri.substring(contextPath.length()); // test1길이만큼 날리기
		
		Controller cont = map.get(path);
		cont.execute(req, resp);   
	}
	
	
}

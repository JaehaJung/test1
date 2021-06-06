package test1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test1.service.Service;
import test1.vo.MemberVO;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String type = request.getParameter("type");
		
		Service s = Service.getInstance();
		int result = s.login(id,pwd, type);
		String path = null;
		int prof=1;
		int stu =2;
		
		
		if (result == prof)
		{
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			path = "/pmenu.jsp";
		}
		
		else if (result == stu)
		{
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			path = "/smenu.jsp";
		}
		
		else 
		{
			path = "/home.jsp";
		}
		HttpUtil.forward(request, response, path);
	}

}

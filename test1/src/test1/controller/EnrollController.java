package test1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test1.controller.HttpUtil;
import test1.service.Service;

public class EnrollController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String subject = request.getParameter("subject");
		int snum= Integer.parseInt(request.getParameter("snum"));
		
		Service s = Service.getInstance();
		s.enroll (id, subject, snum);
		
		HttpUtil.forward(request, response, "/pmenu.jsp");
	}

}

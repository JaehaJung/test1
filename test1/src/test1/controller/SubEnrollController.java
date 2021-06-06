package test1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test1.service.Service;

public class SubEnrollController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		String subid = request.getParameter("subid");
		String path = null;
		
		Service s = Service.getInstance();
		s.subenroll (userid, subid);
		
		path = "smenu.jsp";
		HttpUtil.forward(request, response, path);
	}

}

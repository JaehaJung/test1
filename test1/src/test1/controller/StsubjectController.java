package test1.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test1.service.Service;
import test1.vo.EnrollVO;
import test1.vo.SubjectVO;

public class StsubjectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = null;
		String userid = request.getParameter("userid");
		Service s = Service.getInstance();
		ArrayList <EnrollVO> list = s.Stsubject(userid);
		
		request.setAttribute("list", list);
		path = "/result/StsubjectOutput.jsp";
		HttpUtil.forward(request, response, path);
	}

}

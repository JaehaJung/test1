package test1.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test1.service.Service;
import test1.vo.SubjectVO;

public class SubjectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = null;
		Service s = Service.getInstance();
		ArrayList <SubjectVO> list = s.subject();
		
		request.setAttribute("list", list);
		path = "/result/subjectOutput.jsp";
		HttpUtil.forward(request, response, path);
	}
	

}

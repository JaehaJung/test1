package test1.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
	public static void forward(HttpServletRequest req, HttpServletResponse resp, String Path)
	{
		try
		{
			RequestDispatcher rd = req.getRequestDispatcher(Path);
			rd.forward(req, resp);
		}catch (Exception e) {
			System.out.print("HttpUtil error"+e);
		}
	}


}

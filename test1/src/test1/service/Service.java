package test1.service;

import java.util.ArrayList;

import test1.dao.test1Dao;
import test1.vo.EnrollVO;
import test1.vo.SubjectVO;

public class Service {
	private static Service service = new Service();
	private Service() {}
	private test1Dao dao = test1Dao.getInstance();
	public static Service getInstance()
	{
		return service;
	}
	public int login(String id, String pwd, String type) {
		// TODO Auto-generated method stub
		return dao.login(id,pwd,type);
	}
	public void enroll(String id, String subject, int snum) {
		// TODO Auto-generated method stub
		dao.enroll(id, subject, snum);
	}
	public ArrayList<SubjectVO> subject() {
		// TODO Auto-generated method stub
		ArrayList<SubjectVO> list = dao.subject();
		return list;
	}
	public ArrayList<SubjectVO> St_enroll(String id) {
		// TODO Auto-generated method stub
		ArrayList<SubjectVO> list = dao.St_enroll(id);
		return list;
	}
	public void subenroll(String userid, String subid) {
		// TODO Auto-generated method stub
		dao.subenroll(userid, subid);
	}
	
	public ArrayList<EnrollVO> Stsubject(String userid) {
		// TODO Auto-generated method stub
		ArrayList<EnrollVO> list = dao.Stsubject(userid);
		return list;
	}
	public ArrayList<EnrollVO> subid(String subid) {
		// TODO Auto-generated method stub
		ArrayList<EnrollVO> list = dao.subid(subid);
		return list;
	}
	
}

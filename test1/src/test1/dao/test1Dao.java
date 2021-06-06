package test1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import test1.vo.EnrollVO;
import test1.vo.SubjectVO;

public class test1Dao {
	private static test1Dao dao = new test1Dao();
	private test1Dao() {}
	public static test1Dao getInstance() {
		return dao;
	}
	
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yongin","root","cs1234");
		} catch (Exception e) {
			System.out.print("MDAO:Connect " + e);
		} 
		return conn;
	}
	

	public void close(Connection conn, PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.print("pstmt close error" + e);				
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.print("conn close error" + e);				
			}
		}
	} // close
	
	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		// TODO Auto-generated method stub
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.print("rs close error" + e);				
			}
		}
		close(conn, pstmt);
	} // close
	
	public int login(String id, String pwd, String type) {
		// TODO Auto-generated method stub
		int result= 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String prof = "p";
		String stu = "s";
		try {
			conn = connect();
			
			//교수일 때
			if(prof.equals(type))
			{
			pstmt = conn.prepareStatement("select * from prof where id = ? and pwd = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if (rs.next()) // 값이 있으면.
				result = 1;
			else
				result = 3;
			}
			
			//학생일 때
			if(stu.equals(type))
			{
			pstmt = conn.prepareStatement("select * from student where id = ? and pwd = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if (rs.next()) // 값이 있으면.
				result = 2;
			else
				result = 3;
			}
			
		} catch (Exception e) {
			System.out.print("login error" + e);
		}
		finally
		{
			close(conn, pstmt, rs);
		}
		
		return result;
	}
	public void enroll(String id, String subject, int snum) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

			try {
				conn = connect();
				pstmt = conn.prepareStatement("insert into subject values(?,?,?,1);");
				pstmt.setString(1, id);
				pstmt.setString(2, subject);
				pstmt.setString(3, snum+"");  // +"" : (int형의 string 변환)
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.print("enroll error" + e);
			}
			finally
			{
				close(conn, pstmt, rs);
			}
	}
	public ArrayList<SubjectVO> subject() {
		// TODO Auto-generated method stub
		ArrayList<SubjectVO> list = new ArrayList<SubjectVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		SubjectVO subject = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from subject;");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				subject = new SubjectVO();
				subject.setId(rs.getString(1));
				subject.setName(rs.getString(2));
				subject.setCount(rs.getString(3));
				subject.setProf(rs.getString(4));
				list.add(subject);
			}

			} catch (Exception e) {
				System.out.print("subject error" + e);
			}
			finally
			{
				close(conn, pstmt, rs);
			}
		return list;
	}
	public ArrayList<SubjectVO> St_enroll(String id) {
		// TODO Auto-generated method stub
		ArrayList<SubjectVO> list = new ArrayList<SubjectVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		SubjectVO subject = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from subject where id=?;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				subject = new SubjectVO();
				subject.setId(rs.getString(1));
				subject.setName(rs.getString(2));
				list.add(subject);
			}

			} catch (Exception e) {
				System.out.print("subject error" + e);
			}
			finally
			{
				close(conn, pstmt, rs);
			}
		return list;
	}
	public void subenroll(String userid, String subid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

			try {
				conn = connect();
				pstmt = conn.prepareStatement("insert into enroll values(?,?);");
				pstmt.setString(1, subid);
				pstmt.setString(2, userid);
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.print("subenroll error" + e);
			}
			finally
			{
				close(conn, pstmt, rs);
			}
	}

	public ArrayList<EnrollVO> Stsubject(String userid) {
		// TODO Auto-generated method stub
		ArrayList<EnrollVO> list = new ArrayList<EnrollVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		EnrollVO subject = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from enroll where student = ?;");
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				subject = new EnrollVO();
				subject.setSubject(rs.getString(1));
				subject.setStudent(rs.getString(2));
				list.add(subject);
			}

			} catch (Exception e) {
				System.out.print("subject error" + e);
			}
			finally
			{
				close(conn, pstmt, rs);
			}
		return list;
}
	
	public ArrayList<EnrollVO> subid(String subid) {
		// TODO Auto-generated method stub
		ArrayList<EnrollVO> list = new ArrayList<EnrollVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		EnrollVO subject = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select student.id, student.name from enroll, student where enroll.subject = ?;");
			pstmt.setString(1, subid);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				subject = new EnrollVO();
				subject.setSubject(rs.getString(1));
				subject.setStudent(rs.getString(2));
				list.add(subject);
			}

			} catch (Exception e) {
				System.out.print("subid error" + e);
			}
			finally
			{
				close(conn, pstmt, rs);
			}
		return list;
	}
}
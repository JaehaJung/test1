package test1.vo;

public class EnrollVO {
	private String subject;
	private String student;
	
	public EnrollVO() {}
	public EnrollVO (String tSubject, String tStudent)
	{
		this.subject = tSubject;
		this.student = tStudent;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}


}

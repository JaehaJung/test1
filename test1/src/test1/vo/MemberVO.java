package test1.vo;

public class MemberVO {
	private String id;
	private String pwd;
	private String type;
	
	public MemberVO() {}
	public MemberVO (String tId, String tPwd)
	{
		this.id = tId;
		this.pwd = tPwd;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
		
}


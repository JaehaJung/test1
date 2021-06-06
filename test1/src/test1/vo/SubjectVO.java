package test1.vo;

public class SubjectVO {
	private String id;
	private String name;
	private String count;
	private String prof;
	
	public SubjectVO() {}
	public SubjectVO (String tId, String tName, String tCount, String tProf)
	{
		this.id = tId;
		this.name = tName;
		this.count = tCount;
		this.prof = tProf;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
}

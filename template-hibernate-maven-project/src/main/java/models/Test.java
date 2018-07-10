package models;

public class Test {
	
	private Long id;
	private String testContent;
	public Test() {
		super();
	}
	public Long getId() {
		return id;
	}
	private void setId(Long id) {
		this.id = id;
	}
	public String getTestContent() {
		return testContent;
	}
	public void setTestContent(String testContent) {
		this.testContent = testContent;
	}	
	
}

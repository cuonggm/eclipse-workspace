package models;

public class StudentWrapper {
	
	private Long studentId;
	private String studentName;
	
	public StudentWrapper(Long studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	public Long getStudentId() {
		return studentId;
	}
	public String getStudentName() {
		return studentName;
	}
}

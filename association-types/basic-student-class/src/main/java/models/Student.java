package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="STUDENTS")
public class Student {
	
	@Id
	@GeneratedValue
	@Column(name="STUDENT_ID")
	private Long studentId;
	
	@Column(name="STUDENT_NAME")
	private String studentName;
	
	public Student() {
		
	}
	public Long getStudentId() {
		return studentId;
	}
	private void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
}

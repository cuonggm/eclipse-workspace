package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="STUDENTS")
public class Student {
	
	@Id
	@GeneratedValue
	@Column(name="STUDENT_ID")
	private Long studentId;
	
	@Column(name="STUDENT_NAME")
	private String studentName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="CLASSES_STUDENTS_MANY_TO_MANY",
	joinColumns= {@JoinColumn(name="STUDENT_ID_FKEY")},
	inverseJoinColumns= {@JoinColumn(name="CLASS_ID_FKEY")})
	private List<Class> classes = new ArrayList<>();
	
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
	public List<Class> getClasses() {
		return classes;
	}
	
}

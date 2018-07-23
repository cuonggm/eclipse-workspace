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
import javax.persistence.OneToMany;

@Entity(name="CLASSES")
public class Class {
	
	@Id
	@GeneratedValue
	@Column(name="CLASS_ID")
	private Long classId;
	
	@Column(name="CLASS_NAME")
	private String className;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="CLASS_STUDENTS_RELATIONSHIP", 
		joinColumns=
			@JoinColumn(
				name="CLASS_ID_FKEY"
			),
		inverseJoinColumns=@JoinColumn(
				name="STUDENT_ID_FKEY"
			))
	private List<Student> students = new ArrayList<>();
	
	public Class() {

	}
	public Long getClassId() {
		return classId;
	}
	private void setClassId(Long classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<Student> getStudents() {
		return students;
	}
	
}

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

@Entity(name="CLASSES")
public class Class {
	
	@Id
	@GeneratedValue
	@Column(name="CLASS_ID")
	private Long classId;
	
	@Column(name="CLASS_NAME")
	private String className;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="classes")
	List<Student> students = new ArrayList<>();
	
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
	public void addStudent(Student student) {
		getStudents().add(student);
	}
	public void addStudentBidirect(Student student) {
		getStudents().add(student);
		student.getClasses().add(this);
	}
}

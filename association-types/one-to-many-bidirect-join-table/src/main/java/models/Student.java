package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity(name="STUDENTS")
public class Student {
	
	@Id
	@GeneratedValue
	@Column(name="STUDENT_ID")
	private Long studentId;
	
	@Column(name="STUDENT_NAME")
	private String studentName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinTable(name="CLASS_STUDENTS_RELATIONSHIP",
			joinColumns=@JoinColumn(
				name="STUDENT_ID_FKEY"
			),
			inverseJoinColumns=@JoinColumn(
				name="CLASS_ID_FKEY"
			))
	private Class myClass;
	
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
	public Class getMyClass() {
		return myClass;
	}
	public void setMyClass(Class myClass) {
		this.myClass = myClass;
	}
	public void setMyClassBidirect(Class myClass) {
		this.myClass = myClass;
		myClass.getStudents().add(this);
	}
	
}

package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="CLASSES")
public class Class {
	
	@Id
	@GeneratedValue
	@Column(name="CLASS_ID")
	private Long classId;
	
	@Column(name="CLASS_NAME")
	private String className;
	
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="myClass")
	private Student boss;
	
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
	public Student getBoss() {
		return boss;
	}
	public void setBoss(Student boss) {
		this.boss = boss;
	}
	public void setBossBidirect(Student boss) {
		this.boss = boss;
		boss.setMyClass(this);
	}
	
}

package models;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Student.class)
public class Student_ {
	public static volatile SingularAttribute<Student, Long> studentId;
	public static volatile SingularAttribute<Student, String> studentName;
	public static volatile SingularAttribute<Student, Class> myClass;
}

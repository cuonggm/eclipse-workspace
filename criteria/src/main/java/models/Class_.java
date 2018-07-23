package models;

import java.util.List;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Class.class)
public class Class_ {
	
	public static volatile SingularAttribute<Class, Long> classId;
	public static volatile SingularAttribute<Class, String> className;
	public static volatile ListAttribute<Class, List<Student>> students;

}

package apps;

import org.hibernate.Session;

import models.Class;
import models.Student;
import utils.HibernateUtils;

public class TestFromParent {

	public static void main(String[] argv) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		// BEGIN
		Student student1 = new Student();
		student1.setStudentName("Giap Minh Cuong");
		
		Student student2 = new Student();
		student2.setStudentName("Nguyen Thu Uyen");
		
		Class newClass = new Class();
		newClass.setClassName("Viet Nhat AS K59");
		
		newClass.getStudents().add(student1);
		newClass.getStudents().add(student2);
		
//		session.save(student1);
//		session.save(student2);
		
		session.save(newClass);
		// END
		session.getTransaction().commit();
		session.close();
	}
	
}

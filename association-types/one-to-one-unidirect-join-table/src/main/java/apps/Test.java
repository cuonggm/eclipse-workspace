package apps;

import org.hibernate.Session;

import models.Student;
import models.Class;
import utils.HibernateUtils;

public class Test {
	
	public static void main(String[] argv) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		// BEGIN
		Student student = new Student();
		student.setStudentName("Giap Minh Cuong");
		
		Class newClass = new Class();
		newClass.setClassName("Viet Nhat AS K59");
		
		session.save(student);
		session.save(newClass);
		// END
		session.getTransaction().commit();
		session.close();
	}
	
}

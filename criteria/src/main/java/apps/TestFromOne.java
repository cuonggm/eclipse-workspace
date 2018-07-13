package apps;

import org.hibernate.Session;

import models.Class;
import models.Student;
import utils.HibernateUtils;

public class TestFromOne {
	
	public static void main(String[] argv) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		// BEGIN
		Student student = new Student();
		student.setStudentName("Giap Minh Cuong");
		
		Class newClass = new Class();
		newClass.setClassName("Viet Nhat AS K59");
		
		newClass.addStudentBidirect(student);
		
		session.save(newClass);
		
		// END
		session.getTransaction().commit();
		session.close();
	}
	
}

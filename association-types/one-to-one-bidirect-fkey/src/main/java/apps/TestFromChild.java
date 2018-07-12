package apps;

import org.hibernate.Session;

import models.Class;
import models.Student;
import utils.HibernateUtils;

public class TestFromChild {

	public static void main(String[] argv) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		// BEGIN
		Student student = new Student();
		student.setStudentName("Nguyen Thi Thu Uyen");
		
		Class newClass = new Class();
		newClass.setClassName("TPassion");
		
		student.setMyClassBidirect(newClass);
		
		session.save(student);
		// END
		session.getTransaction().commit();
		session.close();
	}
	
}

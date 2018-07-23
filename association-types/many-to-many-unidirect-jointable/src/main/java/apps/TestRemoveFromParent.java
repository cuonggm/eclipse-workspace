package apps;

import org.hibernate.Session;

import models.Class;
import models.Student;
import utils.HibernateUtils;

public class TestRemoveFromParent {

	public static void main(String[] argv) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		// BEGIN
		Class newClass = session.find(Class.class, new Long(1));
		session.remove(newClass);
		// END
		session.getTransaction().commit();
		session.close();
	}
	
}

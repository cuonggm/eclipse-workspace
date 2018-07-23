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
		Class myClass = session.find(Class.class, new Long(9));
		session.remove(myClass);
		// END
		session.getTransaction().commit();
		session.close();
	}
	
}

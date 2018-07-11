package apps;

import org.hibernate.Session;

import models.Person;
import models.Phone;
import utils.HibernateUtils;

public class TestManyToOne {
	public static void main(String[] argv) { 
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		
		Person person = new Person();
		person.setName("Cuong");
		
		Phone phone = new Phone();
		phone.setNumber(new Long(912126739));
		phone.setOwner(person);
		session.save(phone);
		
		session.getTransaction().commit();
		session.close();
	}
}

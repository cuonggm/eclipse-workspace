package apps;

import org.hibernate.Session;

import models.Person;
import models.Bike;
import utils.HibernateUtils;

public class TestOneToMany {
	public static void main(String[] argv) { 
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		
		Person person = new Person();
		person.setName("Uyen");
		
		Bike bike1 = new Bike();
		bike1.setName("Xe 1");
		bike1.setColor("Xanh");
		person.getBikes().add(bike1);
		
		Bike bike2 = new Bike();
		bike2.setName("Xe 1");
		bike2.setColor("Xanh");
		person.getBikes().add(bike2);
		
		session.save(person);
		
		session.getTransaction().commit();
		session.close();
	}
}

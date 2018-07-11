package apps;

import org.hibernate.Session;

import models.Bike;
import models.Person;
import utils.HibernateUtils;

public class TestBidirectionalOneToMany {
	
	public static void main(String[] agrv) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		
		Person person = new Person();
		person.setName("Uyen");

		Bike bike1 = new Bike();
		bike1.setName("Xe 1");
		bike1.setColor("Xanh");
		person.addBike(bike1);
		
		Bike bike2 = new Bike();
		bike2.setName("Xe 2");
		bike2.setColor("Do");
		person.addBike(bike2);
		
		session.save(person);
		
		session.getTransaction().commit();
		session.close();
	}
}

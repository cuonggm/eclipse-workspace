package entitymanagers;

import org.hibernate.Session;

import models.Event;
import utils.HibernateUtils;

public class EventManager {
	
	public static void main(String[] argv) {
		EventManager eManager = new EventManager();
		eManager.newEvent("Hello World");
	}
	
	public void newEvent(String title) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Event e = new Event();
		e.setTitle(title);
		session.save(e);
		session.getTransaction().commit();
		session.close();
	}
}

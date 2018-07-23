package entitymanagers;

import javax.persistence.EntityManager;

import models.Event;
import utils.HibernateUtils;

public class EventManager {

	public static void main(String[] args) {
		EventManager eManager = new EventManager();
		eManager.newEvent("Hello Other World");
	}
	
	public void newEvent(String title) {
		EntityManager manager = HibernateUtils.getEntityManager().createEntityManager();
		manager.getTransaction().begin();
		Event e = new Event();
		e.setTitle(title);
		manager.persist(e);
		manager.getTransaction().commit();
		manager.close();
	}

}

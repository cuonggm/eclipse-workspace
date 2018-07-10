package entitymanagers;

import org.hibernate.Session;

import models.Test;
import utils.HibernateUtils;

public class TestManager {
	
	public static void main(String[] argv) {
		System.out.println("Start Program");
		
		TestManager testManager = new TestManager();
		testManager.newTest("This is test content");
		
		System.out.println("End Program");
	}
	
	public long newTest(String testContent) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Test t = new Test();
		t.setTestContent(testContent);
		long testId = (long) session.save(t);
		session.getTransaction().commit();
		return testId;
	}
	
}

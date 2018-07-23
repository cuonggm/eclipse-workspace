package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {
	private static final EntityManagerFactory entityManager = buildEntityManager();
	
	private static EntityManagerFactory buildEntityManager() {
		try {
			return Persistence.createEntityManagerFactory("com.cuong.jpa");
		}
		catch(Exception e) {
			System.out.println("Can't create sessionFactory singleton");
			System.out.printf("Error:%s\n", e.getMessage());
		}
		return null;
	}
	
	public static EntityManagerFactory getEntityManager() {
		return entityManager;
	}
}

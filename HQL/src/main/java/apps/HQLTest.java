package apps;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import models.Class;

import utils.HibernateUtils;

public class HQLTest {
	
	private static EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
	
	public static void main(String[] argv) {
		selectTypedQuery();
	}
	
	public static void selectTypedQuery() {
		String queryString = "SELECT C.classId, C.className FROM Class AS C";
		TypedQuery<Object[]> query = entityManager.createQuery(queryString, Object[].class);
		List<Object[]> list = query.getResultList();
		for(Object[] c : list)  {
			System.out.printf("%d | %s\n", c[0], c[1]);
		}
	}
	
}

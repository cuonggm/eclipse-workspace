package criteria;

import models.Student;
import models.Student_;
import utils.HibernateUtils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import models.Class;
public class CriteriaUtils {
	
	private static EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
	
	public static void main(String[] argv) {
//		setupData();
//		normalSelectStudent();
//		columnSelectStudent();
		multipleValuesStudent();
	}
	
	public static void setupData() {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Class[] classes = new Class[5];
		for(int i=0; i<5; i++) {
			classes[i] = new Class();
			classes[i].setClassName("Class"+(i+1));
		}
		
		for(int i=0; i<50; i++) {
			Student s = new Student();
			s.setStudentName("Cuong "+ (i+1));
			int j = i/10;
			s.setMyClass(classes[j]);
			session.save(s);
		}
		
		session.getTransaction().commit();
		session.close();
	}
	public static void deleteStudent(long id) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Student s = session.find(Student.class, new Long(id));
		session.remove(s);
		
		session.getTransaction().commit();
		session.close();
	}
	public static void addStudentIncludeClass(String studentName, String className) {
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Student s = new Student();
		s.setStudentName(studentName);

		Class c = new Class();
		c.setClassName(className);

		s.setMyClassBidirect(c);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public static void normalSelectStudent() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> studentQuery = builder.createQuery(Student.class);
		Root<Student> studentRoot = studentQuery.from(Student.class);
		studentQuery.select(studentRoot);
		studentQuery.where(builder.equal(studentRoot.get(Student_.studentName), "Cuong 3"));
		
		List<Student> list = entityManager.createQuery(studentQuery).getResultList();
		
		for(Student s : list) {
			System.out.println(s);
		}
	}
	
	public static void columnSelectStudent() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> studentQuery = builder.createQuery(String.class);
		Root<Student> studentRoot = studentQuery.from(Student.class);
		studentQuery.select(studentRoot.get(Student_.studentName));
		studentQuery.where(builder.equal(studentRoot.get(Student_.studentName), "Cuong 3"));
		
		List<String> list = entityManager.createQuery(studentQuery).getResultList();
		
		for(String s : list) {
			System.out.println(s);
		}
	}
	
	public static void multipleValuesStudent() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> studentQuery = builder.createQuery(Object[].class);
		Root<Student> studentRoot = studentQuery.from(Student.class);
		Path<String> namesPath = studentRoot.get(Student_.studentName);
		Path<Long> idsPath = studentRoot.get(Student_.studentId);
		studentQuery.multiselect(namesPath, idsPath);
		studentQuery.where(builder.equal(studentRoot.get(Student_.studentName), "Cuong 3"));
		
		List<Object[]> list = entityManager.createQuery(studentQuery).getResultList();
		
		for(Object[] s : list) {
			System.out.printf("%s:%d\n", (String)s[0], (Long)s[1]);
		}
	}
}

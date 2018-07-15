package criteria;

import models.Student;
import models.StudentWrapper;
import models.Student_;
import utils.HibernateUtils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import models.Class;
import models.Class_;
public class CriteriaUtils {
	
	private static EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
	
	public static void main(String[] argv) {
//		setupData();
//		normalSelect();
//		columnSelect();
//		multipleValues();
//		wrapperSelect();
//		tupleSelect();
//		join();
		join2();
//		groupBy();
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
	
	public static void normalSelect() {
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
	
	public static void columnSelect() {
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
	
	public static void multipleValues() {
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
	
	public static void wrapperSelect() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StudentWrapper> studentQuery = builder.createQuery(StudentWrapper.class);
		Root<Student> studentRoot = studentQuery.from(Student.class);
		Path<String> namesPath = studentRoot.get(Student_.studentName);
		Path<Long> idsPath = studentRoot.get(Student_.studentId);
		studentQuery.select(builder.construct(StudentWrapper.class, idsPath, namesPath));
		studentQuery.where(builder.equal(studentRoot.get(Student_.studentName), "Cuong 3"));
		
		List<StudentWrapper> list = entityManager.createQuery(studentQuery).getResultList();
		
		for(StudentWrapper s : list) {
			System.out.printf("id=%d | name=%s\n", s.getStudentId(), s.getStudentName());
		}
	}
	
	public static void tupleSelect() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> studentQuery = builder.createQuery(Tuple.class);
		Root<Student> studentRoot = studentQuery.from(Student.class);
		Path<String> namesPath = studentRoot.get(Student_.studentName);
		Path<Long> idsPath = studentRoot.get(Student_.studentId);
		studentQuery.multiselect(namesPath, idsPath);
		studentQuery.where(builder.equal(studentRoot.get(Student_.studentName), "Cuong 3"));
		
		List<Tuple> list = entityManager.createQuery(studentQuery).getResultList();
		
		for(Tuple s : list) {
			System.out.printf("id=%d | name=%s\n", s.get(idsPath), s.get(namesPath));
		}
	}
	
	public static void join() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> studentQuery = builder.createQuery(Tuple.class);
		
		Root<Student> studentRoot = studentQuery.from(Student.class);
		Join<Student, Class> classJoin = studentRoot.join(Student_.myClass);
		
		Path<Long> idsPath = studentRoot.get(Student_.studentId);
		Path<String> namesPath = studentRoot.get(Student_.studentName);
		
		Path<String> classNamesPath = classJoin.get(Class_.className);
		Path<Long> classIdPath = classJoin.get(Class_.classId);
		
		studentQuery.multiselect(idsPath, 
				namesPath, 
				classNamesPath,
				classIdPath);
		studentQuery.where(builder.equal(studentRoot.get(Student_.studentName), "Cuong 3"));
		
		List<Tuple> list = entityManager.createQuery(studentQuery).getResultList();
		
		
		for(Tuple s : list) {
			System.out.printf("id=%d | name=%s | className=%s| classId=%d\n", 
					s.get(idsPath), 
					s.get(namesPath),
					s.get(classNamesPath),
					s.get(classIdPath));
		}
	}
	
	public static void join2() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> studentQuery = builder.createQuery(Tuple.class);
		
		Root<Student> studentRoot = studentQuery.from(Student.class);
		
		Path<Long> idsPath = studentRoot.get(Student_.studentId);
		Path<String> namesPath = studentRoot.get(Student_.studentName);
		
		Path<Class> classPath = studentRoot.get(Student_.myClass);
		
		studentQuery.multiselect(idsPath, 
				namesPath, 
				classPath);
		//studentQuery.where(builder.equal(studentRoot.get(Student_.studentName), "Cuong 3"));
		
		List<Tuple> list = entityManager.createQuery(studentQuery).getResultList();
		
		
		for(Tuple s : list) {
			System.out.printf("id=%d | name=%s | className=%s| classId=%d\n", 
					s.get(idsPath), 
					s.get(namesPath),
					s.get(classPath).getClassName(),
					s.get(classPath).getClassId());
		}
	}
	
	public static void groupBy() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> query = builder.createQuery(Tuple.class);
		Root<Student> root = query.from(Student.class);
		Path<Class> classPath = root.get(Student_.myClass);
		query.groupBy(classPath);
		Expression<Long> countExpression = builder.count(root);
		query.multiselect(countExpression, classPath);
		List<Tuple> list = entityManager.createQuery(query).getResultList();
		for(Tuple c : list) {
			System.out.printf("%s | %s\n", c.get(classPath).getClassId(), c.get(countExpression));
		}
	}
}

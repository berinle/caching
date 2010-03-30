package net.berinle.caching;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class Seeder {
	public static void main(String[] args) {
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		//do stuff
		for(int j=0; j<15; j++){
		long start = System.currentTimeMillis();
		for(int i=0; i<10000; i++){
			Employee e = new Employee("first_name", "last_name", new Date(), "1");			
			s.save(e);
			if(i % 500 == 0){
				s.flush();
				s.clear();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(" time elapsed: " + (end - start) + " ms");
		}
		
		/*for(int i=0; i<40; i++){
			s.createCriteria(Employee.class).list();
		}*/
		
		s.getTransaction().commit();
		s.close();
	}
}

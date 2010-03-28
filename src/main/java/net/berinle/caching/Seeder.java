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
		Employee e = new Employee("first_name", "last_name", new Date(), "1");
		s.save(e);
		
		s.getTransaction().commit();
		s.close();
	}
}

package net.berinle.caching;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeHibernateDao implements EmployeeDao {

	@Autowired SessionFactory sessionFactory;
	
	public List<Employee> getEmployees() {
		return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
	}

}

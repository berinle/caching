package net.berinle.caching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeHibernateDao implements EmployeeDao {

	private static Logger log = Logger.getLogger(EmployeeHibernateDao.class);
	
	public static int BATCH_SIZE = 100;
	
	@Autowired SessionFactory sessionFactory;
	
	public List<Employee> getEmployees() {
		return sessionFactory.getCurrentSession().createCriteria(Employee.class)
		.setCacheable(true)
		.list();
	}

	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().merge(employee);
	}

	public Map getEmployees(int startIndex) {
		List<Employee> list =  sessionFactory.getCurrentSession().createCriteria(Employee.class)
		//.setFetchSize(100)
		.setMaxResults(100)
		.setFirstResult(startIndex)
		.list();
		
		log.debug("list size returned: " + list.size());
		
		long totalSize = (Long)sessionFactory.getCurrentSession().createQuery("select count(*) from Employee").uniqueResult();
		
		Map map = new HashMap();
		map.put("employees", list);
		map.put("totalSize", totalSize);
		return map;
	}

	public Map getEmployeesManual(int startIndex) {
		List<Employee> list =  sessionFactory.getCurrentSession().createCriteria(Employee.class)
		.setCacheable(true)
		.list();
		
		int start = startIndex-1;
		int end = start + BATCH_SIZE;
		
		if(end > list.size()){
			end = list.size();
		}
		
		List<Employee> temp = list.subList(start,end);
		
		List subList = new ArrayList();
		subList.addAll(temp);
		
		Map map = new HashMap();
		map.put("employees", subList);
		map.put("totalSize", new Long(list.size()));
		return map;
	}

}

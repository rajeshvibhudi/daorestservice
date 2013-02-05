package com.daorest.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.daorest.beans.Employee;
import com.daorest.beans.Location;
import com.daorest.dao.EmployeeDao;
import com.daorest.utils.HibernateUtil;
/*
 * Author Rajesh Vibhudi 
 */
public class EmployeeDaoImpl implements EmployeeDao {

	private static final long serialVersionUID = 1L;
	Session hibernateSession = this.getSession();
	protected Session getSession() {
		return HibernateUtil.getSession();
	}
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
	//	Session hibernateSession = this.getSession();
		hibernateSession.saveOrUpdate(employee);
	}

	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
//		Session hibernateSession = this.getSession();
		hibernateSession.beginTransaction();
		hibernateSession.delete(employee);
		hibernateSession.getTransaction().commit();
	}

	public List<Employee> listAllEmployees(Class clazz) {
		// TODO Auto-generated method stub
		System.out.println(clazz);
		hibernateSession.beginTransaction();
		List<Employee> employeeList = null;
		Query query = hibernateSession.createQuery("from " + clazz.getName());
		employeeList = query.list();
		hibernateSession.getTransaction().commit();
		return employeeList;
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

		hibernateSession.beginTransaction();
		hibernateSession.update(employee);
		hibernateSession.getTransaction().commit();
	}
	public Employee getEmployeeById(Class clazz, int id) {
		// TODO Auto-generated method stub
		Employee employee = null;
		employee = (Employee) hibernateSession.get(clazz, id);
		return employee;
	}

}

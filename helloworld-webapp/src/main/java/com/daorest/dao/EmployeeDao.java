package com.daorest.dao;

import java.io.Serializable;
import java.util.List;

import com.daorest.beans.Employee;

/**
 * @author Rajesh Vibhudi
 *
 */

public interface EmployeeDao extends Serializable {
	
	public void addEmployee(Employee employee);

	public void deleteEmployee(Employee employee);

	public void updateEmployee(Employee employee);

	public List<Employee> listAllEmployees(Class clazz);
	
	public Employee getEmployeeById(Class clazz,int id);

}

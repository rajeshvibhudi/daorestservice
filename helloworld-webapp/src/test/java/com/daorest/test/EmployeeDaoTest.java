/**
 * 
 */
package com.daorest.test;

import com.daorest.beans.Employee;
import com.daorest.beans.Location;
import com.daorest.dao.EmployeeDao;
import com.daorest.dao.LocationDao;
import com.daorest.daoImpl.EmployeeDaoImpl;
import com.daorest.daoImpl.LocationDaoImpl;

/**
 * @author Rajesh Vibhudi
 *
 */
public class EmployeeDaoTest {
	
	/*public void saveEmployee(Employee employee){
		HibernateUtil.beginTransaction();
		
		employeeDao.addEmployee(employee);
		HibernateUtil.commitTransaction();
	}
	public List<Employee> getAllEmployees(){
		List<Employee> employees = null;
		employees=employeeDao.listAllEmployees(Employee.class);
		return employees;
	}
*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee=new Employee();
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		LocationDao locationDao = new LocationDaoImpl();
		//Add employee
		/*employee.setFirstName("rajesh3");
		employee.setLastName("vibhudi3");
		employee.setSalary(100000);
		Location location = locationDao.getLocationById(Location.class, 2);
		employee.setLocation(location);
		System.out.println(employee.toString());
		employeeDao.addEmployee(employee);*/
		//list employees
		/*List<Employee> employees=employeeDao.listAllEmployees(Employee.class);
		for (Employee employee2 : employees) {
			System.out.println(employee2.toString());
			
		}*/
		//update employee
		/*Location location = locationDao.getLocationById(Location.class,3);
		employee=employeeDao.getEmployeeById(Employee.class,2);
		employee.setLocation(location);
		employeeDao.updateEmployee(employee);*/
		//delete employee
	/*	employee=employeeDao.getEmployeeById(Employee.class,6);
		employeeDao.deleteEmployee(employee);*/
		//Get employee by id
		employee=employeeDao.getEmployeeById(Employee.class,1);
		System.out.println(employee.toString());
		
	}

}

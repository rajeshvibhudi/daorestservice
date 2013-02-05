package com.daorest.model;

import java.util.ArrayList;

import com.daorest.beans.Employee;
import com.daorest.beans.Location;
import com.daorest.dao.EmployeeDao;
import com.daorest.dao.LocationDao;
import com.daorest.daoImpl.EmployeeDaoImpl;
import com.daorest.daoImpl.LocationDaoImpl;

public class EmployeeManager {
	EmployeeDao employeeDao = new EmployeeDaoImpl();
	public ArrayList<Employee> getEmployees()throws Exception {
		ArrayList<Employee> employees = null;
		try {
		
		 employees = (ArrayList<Employee>) employeeDao.listAllEmployees(Employee.class);
		 System.out.println(employees);
		}
		catch (Exception e) {
		throw e;
		}
		return employees;
	}
	public void addEmployee(Employee employee){
		employeeDao.addEmployee(employee);
	}
	public void deleteEmployee(Employee employee){
		employeeDao.deleteEmployee(employee);
	}
	public void updateEmployee(Employee employee){
		employeeDao.updateEmployee(employee);
	}
	public Employee getEmployeeById(int empid){
		Employee employee=new EmployeeDaoImpl().getEmployeeById(Employee.class, empid);
		return employee;
	}
	/*public static void main(String[] args) {
		EmployeeManager manager = new EmployeeManager();
		LocationDao locationDao = new LocationDaoImpl();
		Employee employee=new Employee();
		employee.setFirstName("prakas");
		employee.setLastName("dayal");
		Location location= locationDao.getLocationById(Location.class, 1);
		employee.setLocation(location);
		employee.setSalary(10000);
		employee=new EmployeeDaoImpl().getEmployeeById(Employee.class, 4);
		Location location1= locationDao.getLocationById(Location.class, 1);
		employee.setLocation(location1);
		try {
			manager.deleteEmployee(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
	
}

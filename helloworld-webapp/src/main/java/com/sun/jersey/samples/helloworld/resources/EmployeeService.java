package com.sun.jersey.samples.helloworld.resources;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.daorest.beans.Employee;
import com.daorest.model.EmployeeManager;
import com.google.gson.Gson;
//The Java class will be hosted at the URI path "/EmployeeService"
@Path("/EmployeeService")
public class EmployeeService {
	 // The Java method will process HTTP POST requests
	@GET
	@Path("/GetEmployees")
	@Produces("text/plain")
	public String totalEmployees() {
		String feeds = null;
		try {
			ArrayList<Employee> employees = null;
			EmployeeManager employeeManager = new EmployeeManager();
			employees = employeeManager.getEmployees();
			Gson gson = new Gson();
			System.out.println(gson.toJson(employees));
			feeds = gson.toJson(employees);
		}

		catch (Exception e) {
			System.out.println("Exception Error"); // Console
		}
		return feeds.toString();
	}
	
//@QueryParam("id") int  id 
	 @GET 
	    // The Java method will produce content identified by the MIME Media
	    // type "text/plain"
	 @Path("getemployee")
	    @Produces("text/plain")
	    public String getClichedMessage(@Context UriInfo info) {
		 String str="";
	        // Return some cliched textual content
			try {
				//ArrayList<Employee> employees = null;
				int id = Integer.parseInt(info.getQueryParameters().getFirst("id"));
				EmployeeManager employeeManager = new EmployeeManager();
				Employee employee = employeeManager.getEmployeeById(id);
				str=employee.toString();
			}

			catch (Exception e) {
				System.out.println("Exception Error"); // Console
			}

	        return str;
	    }
	 @GET 
	    // The Java method will produce content identified by the MIME Media
	    // type "text/plain"
	 @Path("updateemployee")
	    @Produces("text/plain")
	    public String updateEmployeeMessage() {
		 String str="";
	        // Return some cliched textual content
			try {
				//ArrayList<Employee> employees = null;
				//int id = Integer.parseInt(info.getQueryParameters().getFirst("id"));
				EmployeeManager employeeManager = new EmployeeManager();
				Employee employee = employeeManager.getEmployeeById(2);
				employee.setSalary(1000000);
				employeeManager.updateEmployee(employee);				
				str=employee.toString();
			}

			catch (Exception e) {
				System.out.println("Exception Error"); // Console
			}

	        return str;
	    }
	 @GET 
	    // The Java method will produce content identified by the MIME Media
	    // type "text/plain"
	 @Path("deleteemployee")
	 @Produces("text/plain")
	    public String deleteEmployeeMessage() {
		 String str1="";
			try {
				EmployeeManager employeeManager = new EmployeeManager();
				Employee employee1 = employeeManager.getEmployeeById(7);
				employeeManager.deleteEmployee(employee1);				
			}

			catch (Exception e) {
				System.out.println("Exception Error"); // Console
			}

	        return str1;
	    }
}
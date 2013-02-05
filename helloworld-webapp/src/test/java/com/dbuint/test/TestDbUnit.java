/**
 * 
 */
package com.dbuint.test;

/**
 * @author Rajesh
 *
 */
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import junit.framework.TestCase;

import org.dbunit.Assertion;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.CompositeTable;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.connection.ConnectionProviderFactory;

import com.daorest.beans.Employee;
import com.daorest.beans.Location;
import com.daorest.model.EmployeeManager;

public class TestDbUnit extends TestCase  {
	public static final String TABLE_LOGIN = "login";
	private FlatXmlDataSet loadedDataSet;
	protected Session session;
	protected Configuration config;
	 protected EmployeeManager employeeManager = new EmployeeManager();
	protected void setUp() throws Exception {
		super.setUp();
		config = new Configuration().configure("/hibernate-test.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		session = sf.openSession();
		// Load empty data from an XML dataset
		InputStream is = getClass().getClassLoader().getResource("empty-test-data.xml").openStream();
		IDataSet dataSet = new FlatXmlDataSet(is);
		DatabaseOperation.CLEAN_INSERT.execute(getConnection(), dataSet);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		session.close();
	}

	protected IDatabaseConnection getConnection() throws Exception {
		ConnectionProvider connProvider = ConnectionProviderFactory
				.newConnectionProvider(config.getProperties());
		Connection jdbcConnection = connProvider.getConnection();
		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
		return connection;
	}

	protected void assertDBAsExpected(String expectedDataFile,
			String[] tableNames) throws Exception {
		// Fetch database data after executing your code
		IDatabaseConnection conn = null;
		try {
			conn = getConnection();
			IDataSet actualDataSet = conn.createDataSet(tableNames);
			// Load expected data from an XML dataset
			InputStream is = getClass().getClassLoader().getResource(
					expectedDataFile).openStream();
			IDataSet expectedDataSet = new FlatXmlDataSet(is);
			for (int i = 0; i < tableNames.length; i++) {
				ITable expected = expectedDataSet.getTable(tableNames[i]);
				ITable actual = actualDataSet.getTable(tableNames[i]);
				// converts actual to use the same colums as expected
				ITable trimmedActual = new CompositeTable(expected
						.getTableMetaData(), actual);
				Assertion.assertEquals(expected, trimmedActual);
			}
		} finally {
			if (null != conn) {
				conn.close();
			}
		}
	}
	public void testInsertEmployee() throws Exception {
	  
		Location location = new Location(1,"Ameerpet","Hyderabad","Ap","500006"); 
		Employee employee = new Employee(1, "prakas", "dayal", 100000,location);
		
	    // save and commit
	    session.save(employee);
	    session.flush();
	    // make sure its as expected
	    assertDBAsExpected("emp.xml", new String[]{"employee","location"});
	  }
	public void testDeleteEmployee() throws Exception {
		  
		Employee employee = employeeManager.getEmployeeById(1);
		System.out.println(employee.toString());
	    // save and commit
	    //session.save(employee);
		employeeManager.deleteEmployee(employee);
	    session.flush();
	    // make sure its as expected
	    assertDBAsExpected("delete-test-data.xml", new String[]{"employee","location"});
	  }
}

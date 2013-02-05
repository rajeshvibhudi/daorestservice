package com.dbuint.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

public class EmployeeDbTest extends DatabaseTestCase {
	public static final String TABLE_LOGIN = "employee";
	private FlatXmlDataSet loadedDataSet;

	// Provide a connection to the database
	protected IDatabaseConnection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection jdbcConnection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/employee_db", "root", "");
		return new DatabaseConnection(jdbcConnection);
	}

	// Load the data which will be inserted for the test
	protected IDataSet getDataSet() throws Exception {
		loadedDataSet = new FlatXmlDataSet(this.getClass().getClassLoader()
				.getResourceAsStream("emp.xml"));
		return loadedDataSet;
	}

	// Check that the data has been loaded.
	public void testCheckEmployeeDataLoaded() throws Exception {
		assertNotNull(loadedDataSet);
		int rowCount = loadedDataSet.getTable(TABLE_LOGIN).getRowCount();
		assertEquals(5, rowCount);
	}
	// Check that the data has been loaded.
	public void testCheckEmployeeDataRecordAdd() throws Exception {
		assertNotNull(loadedDataSet);
		int rowCount = loadedDataSet.getTable(TABLE_LOGIN).getRowCount();
		assertEquals(5, rowCount);
	}
}

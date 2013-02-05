package com.dbuint.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;

public class LocationDbTest extends DatabaseTestCase {
	public static final String TABLE_LOGIN = "location";
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
		loadedDataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("location.xml"));
		return loadedDataSet;
	}
	public void testMe() throws Exception
    {
        // Execute the tested code that modify the database here
		ITable actualJoinData = getConnection().createQueryTable("RESULT_NAME","SELECT * FROM location"); 
System.out.println(actualJoinData);
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = loadedDataSet.getTable("location");
        System.out.println(actualTable.toString());
        // Load expected data from an XML dataset
       // new FlatXmlDataSetBuilder().build(new File("expectedDataSet.xml"));
        IDataSet expectedDataSet =  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("location1.xml"));
        ITable expectedTable = expectedDataSet.getTable("location");
        System.out.println(expectedTable.toString());
        // Assert actual database table match expected table
        assertEquals(expectedTable, actualTable);
    }
	// Check that the data has been loaded.
	public void testCheckLocationDataLoaded() throws Exception {
		assertNotNull(loadedDataSet);
		int rowCount = loadedDataSet.getTable(TABLE_LOGIN).getRowCount();
		assertEquals(5, rowCount);
	}

}

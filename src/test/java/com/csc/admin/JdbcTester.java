package com.csc.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.csc.admin.data.DataSource;
import com.csc.admin.data.SqlBuilder;

public class JdbcTester {


	public static void main(String[] args) throws Exception {
		MySQLAccess dao = new MySQLAccess();
		//dao.readDataBase();
		//dao.testC3P0() ;
		//dao.testSrchSql();
	}
}

class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public void testSrchSql() {
		try {
			SqlBuilder bldr = new SqlBuilder();
			//System.out.println(bldr.buildRowListSql("fabric","en"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testC3P0() throws Exception {
		try {
			DataSource ds = DataSource.getInstance();
	        Connection connection = ds.getConnection();
	        connection.close();
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void readDataBase() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			//System.out.println("loading driver...");
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Setup the connection with the DB
			System.out.println("getting database connection...");
			//String url = "jdbc:mysql://localhost:3306/adminbldr";
			//connect = DriverManager.getConnection(url, "test", "0spr3y");
			DataSource ds = DataSource.getInstance();
	        Connection connect = ds.getConnection();

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			System.out.println("executing select query...");
			resultSet = statement
					.executeQuery("select * from fabric");
			writeResultSet(resultSet);

			// PreparedStatements can use variables and are more efficient
			System.out.println("executing insert query...");
			preparedStatement = connect
					.prepareStatement("INSERT INTO fabric(fabric_cd, fabric_nm, fabric_desc, fabric_family_cd, lang_cd, mod_by, mod_dt, pub_stat, pub_dt) VALUES (?,?,?,?,?,?,?,?,?)");
			// Parameters start with 1
			preparedStatement.setString(1, "TST");
			preparedStatement.setString(2, "Test Name");
			preparedStatement.setString(3, "Test Description");
			preparedStatement.setString(4, "FF1");
			preparedStatement.setString(5, "en");
			preparedStatement.setInt(6, 0);
			preparedStatement.setDate(7, new java.sql.Date(new Date().getTime()));
			preparedStatement.setString(8, "MOD");
			preparedStatement.setDate(9, new java.sql.Date(new Date().getTime()));
			
			preparedStatement.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			close();
		}

	}

	private void writeMetaData(ResultSet resultSet) throws SQLException {
		// Now get some metadata from the database
		// Result set get the result of the SQL query

		System.out.println("The columns in the table are: ");

		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " + i + " "
					+ resultSet.getMetaData().getColumnName(i));
		}
	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			String user = resultSet.getString(1);
			String website = resultSet.getString(2);
			String summary = resultSet.getString(3);
			String comment = resultSet.getString(4);
			System.out.println("User: " + user);
			System.out.println("Website: " + website);
			System.out.println("Summary: " + summary);
			System.out.println("Comment: " + comment);
		}
	}

	// You need to close the resultSet
	private void close() {
		try {
			System.out.println("closing result set...");
			if (resultSet != null) {
				resultSet.close();
			}

			System.out.println("closing statement...");
			if (statement != null) {
				statement.close();
			}

			System.out.println("closing connection...");
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}

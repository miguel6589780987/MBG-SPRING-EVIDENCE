package com.towasoftware.mvcspringexample.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 */
public class Conexion {

	private Connection connection;
	public  Conexion() {
		System.out.println("-------- MySQL JDBC Connection Testing ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			
		}

		System.out.println("MySQL JDBC Driver Registered!");
		this.connection = null;

		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			
		} else {
			System.out.println("Failed to make connection!");
			
		}
	}
	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}
	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}

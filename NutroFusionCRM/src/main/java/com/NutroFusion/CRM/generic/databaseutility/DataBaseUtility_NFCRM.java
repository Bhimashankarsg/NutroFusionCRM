package com.NutroFusion.CRM.generic.databaseutility;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DataBaseUtility_NFCRM {
	
	Connection con;

	

	public void getDbconnection() throws SQLException {

		String url = "jdbc:mysql://localhost:3306/projects";
		
		String username = "root";
		
		String password = "root";

		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception E) {

		}
	}

	public void closeDbConnection() throws SQLException {
		try 
		{
			con.close();
		} catch (Exception e) {

		}
	}


}

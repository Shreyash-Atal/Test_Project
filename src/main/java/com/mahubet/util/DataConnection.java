/**
 * 
 */
package com.mahubet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author samird
 *
 */
public class DataConnection {
	private static Connection dataCon;
	
	private DataConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dataCon=DriverManager.getConnection("jdbc:mysql://localhost:3306/cardsitedb","root","root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getDataConnection(){
		if(null==dataCon){
			new DataConnection();
		}
		return dataCon;
	}
}

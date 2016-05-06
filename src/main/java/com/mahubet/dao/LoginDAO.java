/**
 * 
 */
package com.mahubet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mahubet.util.DataConnection;

/**
 * @author samird
 *
 */
public class LoginDAO {
	private Connection dataConn;

	public LoginDAO() {
		dataConn = DataConnection.getDataConnection();
	}

	public boolean validate(String username, String password) {
		boolean isValid = false;
		try {
			Statement statement = dataConn.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM USERS WHERE USERID='"
							+ username + "' and PWD='" + password);
			if (resultSet.next()) {
				isValid = true;
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isValid;
	}
	
	public boolean addUser(String userid,String name,String password,String mobile){
		boolean success=false;
		try {
			PreparedStatement psmt=dataConn.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?)");
			psmt.setString(1,name);
			psmt.setString(2,userid);
			psmt.setString(3,password);
			psmt.setString(4,mobile);
			int n=psmt.executeUpdate();
			if(n>0){
				success=true;
			}
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	
/*	private String encryptPassword(String password,String key){
		
	}
	
	private String decryptPassword(String password,String key){
		
	}*/
}

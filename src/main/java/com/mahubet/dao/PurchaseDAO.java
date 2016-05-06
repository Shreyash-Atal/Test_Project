package com.mahubet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mahubet.util.DataConnection;

public class PurchaseDAO {
	private Connection dataConn;
	
	public PurchaseDAO() {
		dataConn = DataConnection.getDataConnection();
	}

	public boolean validate(int purchase_id) {
		boolean isValid = false;
		try {
			Statement statement = dataConn.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM PURCHASE WHERE purchase_id='"
							+ purchase_id);
			if (resultSet.next()) {
				isValid = true;
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isValid;
	}
	
	public boolean purchase(int purchase_id,int card_id,int user_id,String cpath,String paymentstatus,String addresses,int phone_number,int quantity,String amount){
		boolean success=false;
		try {
			PreparedStatement psmt=dataConn.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?,?,?,?,?)");
			psmt.setInt(1,purchase_id);
			psmt.setInt(2,user_id);
			psmt.setInt(3,card_id);
			psmt.setString(4,cpath);
			psmt.setString(5,paymentstatus);
			psmt.setString(6,addresses);
			psmt.setInt(7, phone_number);
			psmt.setInt(8, quantity);
			psmt.setString(9,amount);
			
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
}

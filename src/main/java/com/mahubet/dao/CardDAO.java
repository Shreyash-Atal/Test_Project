package com.mahubet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mahubet.util.DataConnection;

public class CardDAO {
	private Connection dataConn;

	public CardDAO() {
		dataConn = DataConnection.getDataConnection();
	}

	public boolean validate(int card_id) {
		boolean isValid = false;
		try {
			Statement statement = dataConn.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM CARD WHERE CARDID='"
							+ card_id);
			if (resultSet.next()) {
				isValid = true;
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isValid;
	}
	
	public boolean addCard(int card_id,String cname,String filepath,String keyword,int price){
		boolean success=false;
		try {
			PreparedStatement psmt=dataConn.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?)");
			psmt.setInt(1,card_id);
			psmt.setString(2,cname);
			psmt.setString(3,filepath);
			psmt.setString(4,keyword);
			psmt.setInt(5, price);
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

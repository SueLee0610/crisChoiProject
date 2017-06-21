package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHandler {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	final private String COLUMN_ID = "iddisneydata";
	final private String COLUMN_SCORE = "score";
	final private String COLUMN_LEVEL = "level";
	
	final private String host = "localhost:3306";
	final private String user = "root";
	final private String password = "apmsetup";
	
	public void readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/?user=" + user + "&password=" + password);
			resultSet = statement.executeQuery("select * from test2.disneydata");
			
			printResultSet(resultSet);
			
			preparedStatement = connect.prepareStatement("insert into test2.disneydata (" + COLUMN_ID + "," + COLUMN_SCORE + "," + COLUMN_LEVEL + ") values (?, ?, ?)");
			preparedStatement.setInt(1,  24);
			preparedStatement.setInt(2, 2000);
			preparedStatement.setString(3, "Test");
			preparedStatement.executeUpdate();
			
			preparedStatement = connect.prepareStatement("SELECT iddisneydata, score, level from test2.disneydata");
			resultSet = preparedStatement.executeQuery();
			printResultSet(resultSet);
			
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
		
		
		
	}
	
	 private void printResultSet(ResultSet resultSet) throws SQLException {
		    // ResultSet is initially before the first data set
		    while (resultSet.next()) {
		      int id = resultSet.getInt(COLUMN_ID);
		      int score = resultSet.getInt(COLUMN_SCORE);
		      String level = resultSet.getString(COLUMN_LEVEL);
		  
		      System.out.println("Id: " + id);
		      System.out.println("Score: " + score);
		      System.out.println("Level: " + level);
		   }
	}
	 
	 private void close() {
		 try {
			 if (resultSet != null) {
				 resultSet.close();
		     }
		     if (statement != null) {
		    	 statement.close();
		     }

		     if (connect != null) {
		    	 connect.close();
		     }
		 } catch (Exception e) {

		 }
	 }
}

package com.javaJDBCAndAPIWithStatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteCustomer 
{
	
	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		try
		{
			connection = DatabaseConnection.getDatabaseConnection();//connection
			
			//create statement object
			Statement statement = connection.createStatement();
			
			Customer customer = new Customer();
			customer.setCustomerId(111);
			
			//create query for to customer object.
			String query = "delete from customer where customer_id = '"+customer.getCustomerId()+"'";
			
			int status = statement.executeUpdate(query);
			
			System.out.println(status+ " customer object deleted.");
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{			
			connection.close();	
		}
		
		
	}

}

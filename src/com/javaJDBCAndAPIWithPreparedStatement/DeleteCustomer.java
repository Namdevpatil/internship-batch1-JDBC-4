package com.javaJDBCAndAPIWithPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCustomer 
{
	
	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		try
		{
			connection = DatabaseConnection.getDatabaseConnection();//connection
			
			//create statement object
			//Statement statement = connection.createStatement();
			
			Customer customer = new Customer();
			customer.setCustomerId(300);
			
			//create query for to customer object.
			String query = "delete from customer where customer_id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, customer.getCustomerId());
			
			int status = preparedStatement.executeUpdate();
			
			if(status > 0)
			{
				System.out.println(status+ " customer object is deleted.");
			}
			else
			{
				System.out.println("customer object is not deleted.");
			}
			
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

package com.javaJDBCAndAPIWithPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveCustomer 
{
	
	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		try
		{
			connection = DatabaseConnection.getDatabaseConnection();//connection
			
			//create statement object
			//Statement statement = connection.createStatement();			
			
			Customer customer = new Customer(340, "Lalitha", "6779893344", "Mumbai");
			
			//create query for to customer object.
			String query = "insert into customer(customer_id, customer_name, customer_contact, customer_address) values(?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, customer.getCustomerId());
			preparedStatement.setString(2, customer.getCustomerName());
			preparedStatement.setString(3, customer.getCustomerContact());
			preparedStatement.setString(4, customer.getCustomerAddress());
			
			//execute query
			int status = preparedStatement.executeUpdate();
			
			if(status > 0)
			{
				System.out.println(status+" customer object stored in database table.");
			}
			else
			{
				System.out.println("customer object is not stored in database table.");
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

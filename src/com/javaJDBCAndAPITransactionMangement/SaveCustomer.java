package com.javaJDBCAndAPITransactionMangement;

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
			
			//database connection object
			connection = DatabaseConnection.getDatabaseConnection();
			
			//disable the autoCommint of MySQL server.
			connection.setAutoCommit(false);
			
			//Customer object
			Customer customer = new Customer(450, "Sunitha", "8799893344", "Delhi");
			
			//create query for to customer object.
			String query = "insert into customer(customer_id, customer_name, customer_contact, customer_address) values(?, ?, ?, ?)";
			
			//Query statement object
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			//set values to query statement
			preparedStatement.setInt(1, customer.getCustomerId());
			preparedStatement.setString(2, customer.getCustomerName());
			preparedStatement.setString(3, customer.getCustomerContact());
			preparedStatement.setString(4, customer.getCustomerAddress());
			
			//execute query
			int status = preparedStatement.executeUpdate();
			
			connection.commit();//committed the operation
			
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

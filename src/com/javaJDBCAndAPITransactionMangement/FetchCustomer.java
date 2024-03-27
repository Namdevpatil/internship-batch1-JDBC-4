package com.javaJDBCAndAPITransactionMangement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchCustomer 
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
			customer.setCustomerId(222);
			
			//create query for to customer object.
			String query = "select customer_id, customer_name, customer_contact, customer_address from customer where customer_id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, customer.getCustomerId());
			
			//execute query			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String contact = resultSet.getString(3);
				String address = resultSet.getString(4);
				
				Customer customer2=new Customer(id, name, contact, address);
				
				System.out.println(customer2.toString());
				
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

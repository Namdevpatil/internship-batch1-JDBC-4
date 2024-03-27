package com.javaJDBCAndAPIWithPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FetchCustomers 
{
	
	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		try
		{
			
			connection = DatabaseConnection.getDatabaseConnection();//connection
			
					
			//create query for to customer object.
			String query = "select * from customer";			
			
			//create statement object
			//Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			//execute query			
			ResultSet resultSet = preparedStatement.executeQuery(query);
			
			//list of customers
			List<Customer> customers = new ArrayList<Customer>();
			
			while(resultSet.next())
			{
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String contact = resultSet.getString(3);
				String address = resultSet.getString(4);
				
				Customer customer = new Customer(id, name, contact, address);				
				customers.add(customer);				
			}
			
			for(Customer customer: customers)
			{
				System.out.println(customer.toString());
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

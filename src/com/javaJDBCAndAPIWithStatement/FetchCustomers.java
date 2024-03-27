package com.javaJDBCAndAPIWithStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			
			//create statement object
			Statement statement = connection.createStatement();
			
			//create query for to customer object.
			//String query = "select customer_id, customer_name, customer_contact, customer_address from customer";
			String query = "select * from customer";			
			
			//execute query			
			ResultSet resultSet = statement.executeQuery(query);
			
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

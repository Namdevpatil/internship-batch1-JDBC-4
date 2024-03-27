package com.javaJDBCAndAPIWithStatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateCustomer 
{
	
	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		try
		{
			connection = DatabaseConnection.getDatabaseConnection();//connection
			
			//create statement object
			Statement statement = connection.createStatement();
			
			Customer customer = new Customer(100, "John David", "7070909080", "Pune");			
			
			//create query for to customer object.
			String query = "update customer set customer_name = '"+customer.getCustomerName()+"', customer_contact = '"+customer.getCustomerContact()+"', customer_address = '"+customer.getCustomerAddress()+"' where customer_id = '"+customer.getCustomerId()+"'";
								
			int status = statement.executeUpdate(query);
			
			System.out.println(status +" customer object is updated");
			
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

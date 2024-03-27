package com.javaJDBCAndAPIWithStatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveCustomer 
{
	
	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		try
		{
			connection = DatabaseConnection.getDatabaseConnection();//connection
			
			//create statement object
			Statement statement = connection.createStatement();
			
			//Customer customer1 = new Customer(111, "Jayesh Kumar", "9090897867", "Hyderabad");
			//Customer customer2 = new Customer(222, "Satish Kumar", "9099999990", "Hyderabad");
			//Customer customer3 = new Customer(333, "Ganesh Patil", "8899897867", "Vizag");
			//Customer customer4 = new Customer(100, "John", "7099999990", "Pune");
			Customer customer5 = new Customer(300, "Raj", "6779897867", "Chennai");
			
			//create query for to customer object.
			String query = "insert into customer(customer_id, customer_name, customer_contact, customer_address) values('"+customer5.getCustomerId()+"', '"+customer5.getCustomerName()+"', '"+customer5.getCustomerContact()+"', '"+customer5.getCustomerAddress()+"')";
			
			//execute query
			int status = statement.executeUpdate(query);
			
			System.out.println(status+" customer object stored in database table.");
			
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

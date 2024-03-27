package com.javaJDBCAndAPITransactionMangement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCustomer 
{
	
	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;
		
		try
		{
			connection = DatabaseConnection.getDatabaseConnection();//connection
			
			//create statement object
			//Statement statement = connection.createStatement();
			
			Customer customer = new Customer(300, "John David", "8989898900", "Mumbai");			
			
			//create query for to customer object.
			String query = "update customer set customer_name = ?, customer_contact = ?, customer_address = ? where customer_id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			
			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setString(2, customer.getCustomerContact());
			preparedStatement.setString(3, customer.getCustomerAddress());
			
			preparedStatement.setInt(4, customer.getCustomerId());
			
			
			int status = preparedStatement.executeUpdate();
			
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

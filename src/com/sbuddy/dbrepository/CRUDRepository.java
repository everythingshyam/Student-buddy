package com.sbuddy.dbrepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sbuddy.entity.Shop;
import com.sbuddy.entity.Student;

public class CRUDRepository {

	
	public static String saveStudent(Student student)
	{
		Connection connection=DBConnection.getConnection();
		
		String sql="insert into student ( name, email, contact, address, password, xCoordinate, yCoordinate) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pStatement=connection.prepareStatement(sql);
			
			pStatement.setString(1, student.getName());
			pStatement.setString(2, student.getEmail());
			pStatement.setString(3, student.getContact());
			pStatement.setString(4, student.getAddress());
			pStatement.setString(5, student.getPassword());
			pStatement.setInt(6, student.getxCoordinate());
			pStatement.setInt(7, student.getyCoordinate());
			
			int i=pStatement.executeUpdate();
			System.out.println(i+"records inserted...");
			
			return "Record added successfully...";
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "Failed to add the record...";
		}
	}
	
	public static String updateStudent(Student student)
	{
		Connection connection=DBConnection.getConnection();
		
		String sql="update student name=? ,email=? ,contact=?, address=?, password=?, xCoordinate=?, yCoordinate=? where id=?";
		try {
			PreparedStatement pStatement=connection.prepareStatement(sql);
			
			pStatement.setString(1, student.getName());
			pStatement.setString(2, student.getEmail());
			pStatement.setString(3, student.getContact());
			pStatement.setString(4, student.getAddress());
			pStatement.setString(5, student.getPassword());
			pStatement.setInt(6, student.getxCoordinate());
			pStatement.setInt(7, student.getyCoordinate());
			pStatement.setInt(8, student.getUID());
			
			int i=pStatement.executeUpdate();
			System.out.println(i+"records update...");
			
			return "Record updated succcessfully...";
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "Failed to update the record...";
		}
	}
	public static ResultSet getStudents()
	{
		Connection connection=DBConnection.getConnection();
		String sql="select * from student";
		
		try {
			PreparedStatement pStatement=connection.prepareStatement(sql);
			ResultSet resultSet= pStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static Student getStudent(int id)
	{
		Connection connection=DBConnection.getConnection();
		String sql="select * from student where UID=?";
		
		try {
			PreparedStatement pStatement=connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			ResultSet resultSet= pStatement.executeQuery();
			
			Student student=null;
			if(resultSet.next()==true)
			{
				int selectedUID=resultSet.getInt(1);
				String selectedName=resultSet.getString(2);
				String selectedEmail=resultSet.getString(3);
				String selectedContact=resultSet.getString(4);
				String selectedAddress=resultSet.getString(5);
				String selectedPassword=resultSet.getString(6);
				int selectedX=resultSet.getInt(7);
				int selectedY=resultSet.getInt(8);
				
				student=new Student(selectedUID,selectedName,selectedEmail,selectedContact,selectedAddress,selectedPassword,selectedX,selectedY);
			}
			
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static String deleteStudent(int id)
	{
Connection connection=DBConnection.getConnection();
		
		String sql="delete from student where UID=?";
		try {
			PreparedStatement pStatement=connection.prepareStatement(sql);
			
			pStatement.setInt(1, id);
			
			int i=pStatement.executeUpdate();
			System.out.println(i+"records deleted...");
			
			return "Record deleted successfully...";
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "Failed to delete the record...";
		}
	}
	
	public static int getLoginUID(String email,String password)
	{
		Connection connection=DBConnection.getConnection();
		int uid=0;
		String sql="select uid from student where email=? and password=?";
		try {
			PreparedStatement pStatement=connection.prepareStatement(sql);
			
			pStatement.setString(1, email);
			pStatement.setString(2, password);
			
			ResultSet resultSet= pStatement.executeQuery();
			if(resultSet.next()==true)
			{
				uid=resultSet.getInt(1);
				System.out.println("UID Matched: "+uid);
				return uid;
			}
			else
				return 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public static void commit()
	{
		Connection connection=DBConnection.getConnection();
//		int uid=0;
		String sql="commit";
		try {
			PreparedStatement pStatement=connection.prepareStatement(sql);
			
			pStatement.execute();
			System.out.println("Commit Successful.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//functions for shop table in database
	
	public static String saveShop(Shop shop)
	{
		Connection connection=DBConnection.getConnection();
		
		String sql="insert into student ( shop_name, owner_name, email, contact, password, xCoordinate, yCoordinate) values(?,?,?,?,?,?)";
		try {
			PreparedStatement pStatement=connection.prepareStatement(sql);
			
			pStatement.setString(1, shop.getShop_name());
			pStatement.setString(2, shop.getOwner_name());
			pStatement.setString(3, shop.getEmail());
			pStatement.setString(4, shop.getContact());
			pStatement.setString(5, shop.getPassword());
			pStatement.setInt(6, shop.getxCoordinate());
			pStatement.setInt(7, shop.getyCoordinate());
			
			int i=pStatement.executeUpdate();
			System.out.println(i+"shop records inserted...");
			
			return "Record added successfully...";
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "Failed to add the shop record...";
		}
	}
	
}

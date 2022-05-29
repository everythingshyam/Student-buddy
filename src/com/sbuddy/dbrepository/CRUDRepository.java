package com.sbuddy.dbrepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sbuddy.entity.Student;

public class CRUDRepository {

	
	public static String saveStudent(Student student)
	{
		Connection connection=DBConnection.getConnection();
		
		String sql="insert into student (name,email_id,contact,address) values(?,?,?,?)";
		try {
			PreparedStatement pStatement=connection.prepareStatement(sql);
			
			pStatement.setString(1, student.getName());
			pStatement.setString(2, student.getEmail());
			pStatement.setString(3, student.getContact());
			pStatement.setString(4, student.getAddress());
			
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
		
		String sql="update student name=? ,email_id=? ,contact=?, address=? where id=?";
		try {
			PreparedStatement pStatement=connection.prepareStatement(sql);
			
			pStatement.setString(1, student.getName());
			pStatement.setString(2, student.getEmail());
			pStatement.setString(3, student.getContact());
			pStatement.setString(4, student.getAddress());
			pStatement.setInt(5, student.getUID());
			
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
				
				student=new Student(selectedUID,selectedName,selectedEmail,selectedContact,selectedAddress);
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
	
}

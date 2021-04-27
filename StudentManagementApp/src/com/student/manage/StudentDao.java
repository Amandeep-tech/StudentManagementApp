package com.student.manage;

import java.sql.*;

import java.util.Scanner;
public class StudentDao {

	public static Boolean insertStudentToDB(Student st) {
		
		Boolean studentInserted = false;
		try {
			// jdbc code
			Connection con = ConnectionProvider.createConnection();
			String sql = "insert into students(sname, sphone, scity) values(?, ?, ?)";
			
			// prepare statement
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			// set the values of parameters (?, ?, ?)
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			// execute the query
			pstmt.executeUpdate();
			studentInserted = true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return studentInserted;
	}
	
	public static Boolean deleteStudentFromDB(int id) {
		
		Boolean studentDeleted = false;
		try {
			// jdbc code
			Connection con = ConnectionProvider.createConnection();
			String sql = "delete from students where sid = ?";
			
			// prepare statement
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			// set the values of parameters (?)
			pstmt.setInt(1, id);
			
			
			// execute the query
			pstmt.executeUpdate();
			studentDeleted = true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return studentDeleted;
		
	}

	public static void displayAllStudents() {
		
		try {
			Connection con = ConnectionProvider.createConnection();
			String sql = "select *from students";
			
			// this time no prepare statements 
			// only statements :)
			Statement stmt = con.createStatement();
			// executeQuery(sql) will return multiple rows as output :)
			ResultSet resultset = stmt.executeQuery(sql);
			
			while(resultset.next()) {
				
				int sid = resultset.getInt(1);
				String sname = resultset.getString(2);
				String sphone = resultset.getString(3);
				String scity = resultset.getString(4);
				
				System.out.println("Student ID :" + sid);
				System.out.println("Student Name : " + sname);
				System.out.println("Student Phone : " + sphone);
				System.out.println("Student City  : " + scity);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static Boolean updateStudent(int id) {
		
		Boolean dataUpdated = false;
		try {
			Scanner sc = new Scanner(System.in);
			
			// here I am only allowing student to update their phone number only.
			System.out.println("Enter the updated value for sphone column");
			int val = sc.nextInt();
		
			Connection con = ConnectionProvider.createConnection();
			String sql = "update students set sphone = ? where sid = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  val);
			pstmt.setInt(2, id);
			
			pstmt.executeUpdate();
			dataUpdated = true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}
}

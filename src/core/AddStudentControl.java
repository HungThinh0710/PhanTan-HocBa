package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import backend.ConnectionInstance;
import model.Student;

public class AddStudentControl {

	private Connection conn;
	private ConnectionInstance CI;
	
	public AddStudentControl() {
		ConnectionInstance CI = new ConnectionInstance();
		this.CI = CI;
	}
	
	public boolean addStudent(Student student) {
		boolean result = false;
		try {
			this.conn = CI.prepareServerInstance(2);
			String sqlQuery = "INSERT INTO students (first_name, last_name, address, phone_number, dob, home_town, school_id, academic_year_start) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			
			 PreparedStatement stmt = conn.prepareStatement(sqlQuery);
			 
			 //Set Param
			 stmt.setString(1, student.getFirstName());
			 stmt.setString(2, student.getlastName());
			 stmt.setString(3, student.getAddress());
			 stmt.setString(4, student.getPhoneNumber());
			 stmt.setDate(5, java.sql.Date.valueOf("1999-03-07") );
			 stmt.setString(6, student.getHomeTown());
			 stmt.setInt(7, Integer.parseInt(student.getSchoolId()));
			 stmt.setDate(8 ,java.sql.Date.valueOf(student.getAcademicYearStart()));
			 int i = stmt.executeUpdate();
			 
			 //Close connection
			 stmt.close();
			 conn.close();
			 
			 if (i > 0) {
			     result = true;
			 } else {
			     result = false;
			 }
	         
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			result = false;
		}
		
		return result;
	}
}

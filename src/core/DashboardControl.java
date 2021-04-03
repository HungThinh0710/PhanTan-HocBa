package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import backend.ConnectionInstance;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import model.Student;

public class DashboardControl {
	private Connection conn;
	private String column[];
	private String students[];
	private ConnectionInstance CI;
	private ArrayList<Student> studentList = new ArrayList();

	public DashboardControl(){
		ConnectionInstance CI = new ConnectionInstance();
		this.CI = CI;
	}
	
	public static String[] getHeaderTable() {
		String column[] = {"ID", "Họ", "Tên", "Địa chỉ", "SĐT", "Giới tính", "Quê quán", "Trường", "Năm vào học" };
		return column;
	}
	
	public ArrayList<Student> getArrayListStudent() {
		try {
			this.conn = CI.prepareServerInstance(1);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM students");
			ResultSetMetaData rsmd = rs.getMetaData();
			
			String data[][] = {};
			Student student;
			
			//Clear old ArrayList
			studentList.clear(); //SO FUCKING IMPORTANT
			
			while (rs.next()) {
				int ID = rs.getInt("ID");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String address = rs.getString("address");
				String phoneNumber = rs.getString("phone_number");
				String gender = rs.getString("gender");
				String homeTown = rs.getString("home_town");
				String schoolId = rs.getString("school_id");
				String academicYearStart = rs.getString("academic_year_start");
				student = new Student(ID, firstName, lastName, address, phoneNumber, gender, homeTown, schoolId, academicYearStart);
				studentList.add(student);
			}
			
			// Close connection
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return studentList;
	}
	
	public boolean changeStudentInformation(Student student) {
		boolean result = false;
		try {
			this.conn = CI.prepareServerInstance(2);
			String sqlQuery = "UPDATE students SET first_name=?, last_name=?, address=?, phone_number=?, dob=?, home_town=? WHERE ID=?";
			
			 PreparedStatement stmt = conn.prepareStatement(sqlQuery);
			 
			 //Set Param
			 stmt.setString(1, student.getFirstName());
			 stmt.setString(2, student.getlastName());
			 stmt.setString(3, student.getAddress());
			 stmt.setString(4, student.getPhoneNumber());
			 stmt.setDate(5, java.sql.Date.valueOf("1999-03-07") );
			 stmt.setString(6, student.getHomeTown());
			 stmt.setInt(7, student.getId());
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
			result = false;
		}
		
		return result;
	}
}

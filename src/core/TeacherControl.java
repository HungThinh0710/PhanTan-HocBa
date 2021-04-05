package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import backend.ConnectionInstance;
import model.Student;
import model.Teacher;

public class TeacherControl {
	private Connection conn;
	private String column[];
	private String students[];
	private ConnectionInstance CI;
	private ArrayList<Teacher> teacherList = new ArrayList();

	public TeacherControl(){
		ConnectionInstance CI = new ConnectionInstance();
		this.CI = CI;
	}
	
	public static String[] getHeaderTable() {
		String column[] = {"ID", "Họ", "Tên", "Ngày sinh", "SĐT", "Giới tính", "Quê quán", "Trường", "Môn phụ trách" };
		return column;
	}
	
	public ArrayList<Teacher> getArrayListStudent() {
		try {
			this.conn = CI.prepareServerInstance(1);
			Statement stmt = conn.createStatement();
			String sqlQuery = "SELECT * FROM subject_teacher sjtc "
					+ "JOIN teachers tc ON (sjtc.teacher_id = tc.id)"
					+ "JOIN subjects sj ON (sjtc.subject_id = sj.id) "
					+ "INNER JOIN schools ON school_id = schools.id";
			ResultSet rs = stmt.executeQuery(sqlQuery);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			String data[][] = {};
			Teacher teacher;
			
			//Clear old ArrayList
			teacherList.clear();
			
			while (rs.next()) {
				int ID = rs.getInt("ID");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Date dob = rs.getDate("dob");
				String phoneNumber = rs.getString("phone_number");
				String gender = rs.getString("gender");
				String homeTown = rs.getString("home_town");
				int schoolId = rs.getInt("school_id");
				String schoolName = rs.getString("school_name");
				String subjectName = rs.getString("subject_name");
				teacher = new Teacher(ID, firstName, lastName, dob, phoneNumber, gender, homeTown, schoolId, schoolName, subjectName);
				teacherList.add(teacher);
			}
			
			// Close connection
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return teacherList;
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

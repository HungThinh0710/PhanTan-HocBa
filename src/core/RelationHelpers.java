package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import backend.ConnectionInstance;
import model.Report;
import model.Student;

public class RelationHelpers {
	private Connection conn;
	private ConnectionInstance CI;
	
	public RelationHelpers() {
		ConnectionInstance CI = new ConnectionInstance();
		this.CI = CI;
	}
		
	public String getSchoolById(int schoolId) {
		String schoolName = null;
		try {
			this.conn = CI.prepareServerInstance(1);
			String sqlQuery = "SELECT * FROM subject_teacher sjtc "
					+ "JOIN teachers tc ON (sjtc.teacher_id = tc.id) and  (tc.id = ?)"
					+ "JOIN subjects sj ON (sjtc.subject_id = sj.id) "
					+ "INNER JOIN schools ON school_id = schools.id";
			
//			String sqlQuery = "SELECT school_name from schools WHERE id = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sqlQuery);
			 
			//Set Param
			stmt.setInt(1, schoolId);
			ResultSet rs = stmt.executeQuery();			
			while (rs.next()) {
				schoolName = rs.getString("school_name");
			}
			
			// Close connection
			conn.close(); 
			} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			}
		return schoolName;
	}
}

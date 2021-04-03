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
import model.Report;
import model.Student;

public class InputPointControl {
	private Connection conn;
	private String column[];
	private String reports[];
	private ConnectionInstance CI;
	private ArrayList<Report> reportList = new ArrayList();
	private int studentId;
	
	public InputPointControl(int studentId){
		ConnectionInstance CI = new ConnectionInstance();
		this.CI = CI;
		this.studentId = studentId;
	}
	
	public static String[] getHeaderTable() {
		String column[] = {"Học Kỳ", "Môn", "Điểm miệng", "Điểm 15 phút", "Điểm 1 tiết", "Điểm giữa kỳ", "Điểm cuối kì", "ĐTB"};
		return column;
	}
	
	public String convertSubjectIdToName(int subjectId) {
		String subjectName = null;
		try {
			this.conn = CI.prepareServerInstance(1);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT subject_name FROM subjects WHERE id = " + subjectId);
			ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next()) {
				subjectName = rs.getString("subject_name");
			}
			
			conn.close();
			stmt.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return subjectName;
	}
	
	public ArrayList<Report> getReportStudent(int studentIdForwarded) {
		
		try {
			this.conn = CI.prepareServerInstance(1);
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM reports WHERE student_id = 2333");
		
			ResultSetMetaData rsmd = rs.getMetaData();
			
			String data[][] = {};
			Report report;
			
			//Clear old ArrayList
			reportList.clear();
			
			while (rs.next()) {
				int ID = rs.getInt("ID");
				int studentId = rs.getInt("student_id");
				int classId = rs.getInt("class_id");
				int subjectId = rs.getInt("subject_id");
				Float dailyExam = rs.getFloat("daily_exam");
				Float fifteenExam = rs.getFloat("fifteen_exam");
				Float onePeriodExam = rs.getFloat("one_period_exam");
				Float middleSemester = rs.getFloat("middle_semester");
				Float finalSemester = rs.getFloat("final_semester");
				Date reportYear = rs.getDate("report_year");
				int semeter = rs.getInt("semeter");
				report = new Report(ID, studentId, classId, subjectId, dailyExam, fifteenExam, onePeriodExam, middleSemester, finalSemester, reportYear, semeter);
				reportList.add(report);
			}
			
			// Close connection
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return reportList;
	}
	
	public Student liteStudentInfo() {
		Student student = new Student();
		try {
			this.conn = CI.prepareServerInstance(1);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE id = " + this.studentId);
			
			while (rs.next()) {
				int ID = rs.getInt("ID");
				student.setFirstName(rs.getString("first_name"));
				student.setlastName(rs.getString("last_name"));
				student.setSchoolId(rs.getString("school_id"));
				student.setAcademicYearStart(rs.getString("academic_year_start"));
			}
			
			// Close connection
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return student;
	}
}

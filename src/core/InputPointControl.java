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

	public InputPointControl(int studentId) {
		ConnectionInstance CI = new ConnectionInstance();
		this.CI = CI;
		this.studentId = studentId;
	}

	public static String[] getHeaderTable() {
		String column[] = {"ID", "Học Kỳ", "Môn", "Điểm miệng", "Điểm 15 phút", "Điểm 1 tiết", "Điểm giữa kỳ",
				"Điểm cuối kì", "ĐTB" };
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
		System.out.println("DEBUG_CONTROL_1");
		System.out.println(studentIdForwarded);
		try {
			this.conn = CI.prepareServerInstance(2);

			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT * FROM reports WHERE student_id = 2333"); //OLD query
			ResultSet rs = stmt.executeQuery(
					"SELECT rp.*, cls.class_name, subj.subject_name, std.first_name, std.last_name, std.academic_year_start FROM reports as rp INNER JOIN classes as cls ON class_id = cls.id INNER JOIN students as std ON student_id = std.id INNER JOIN subjects as subj ON subject_id = subj.id WHERE student_id = "+studentIdForwarded+";");
			ResultSetMetaData rsmd = rs.getMetaData();

			String data[][] = {};
			Report report;

			// Clear old ArrayList
			reportList.clear();

			while (rs.next()) {
				int ID = rs.getInt("ID");
				int studentId = rs.getInt("student_id");
				int classId = rs.getInt("class_id");
				int subjectId = rs.getInt("subject_id");
				String subjectName = rs.getString("subject_name");
				Float dailyExam = rs.getFloat("daily_exam");
				Float fifteenExam = rs.getFloat("fifteen_exam");
				Float onePeriodExam = rs.getFloat("one_period_exam");
				Float middleSemester = rs.getFloat("middle_semester");
				Float finalSemester = rs.getFloat("final_semester");
				Date reportYear = rs.getDate("report_year");
				int semeter = rs.getInt("semeter");
				String className = rs.getString("class_name");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String academicYear = rs.getString("academic_year_start");
				report = new Report(ID, studentId, classId, subjectId, subjectName, dailyExam, fifteenExam,
						onePeriodExam, middleSemester, finalSemester, reportYear, semeter, className, firstName,
						lastName, academicYear);
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

	public boolean updatePoint(Report reportObject) {
		boolean result = false;
		try {
			this.conn = CI.prepareServerInstance(2);
			
			String sqlQuery = "UPDATE reports SET daily_exam=?, fifteen_exam=?, one_period_exam=?, middle_semester=?, final_semester=? WHERE ID=?";
			PreparedStatement stmt = conn.prepareStatement(sqlQuery);
			stmt.setFloat(1, reportObject.getDailyExam());
			stmt.setFloat(2, reportObject.getFifteenExam());
			stmt.setFloat(3, reportObject.getOnePeriodExam());
			stmt.setFloat(4, reportObject.getMiddleSemester());
			stmt.setFloat(5, reportObject.getFinalSemester());
			stmt.setFloat(6, reportObject.getId());
			int i = stmt.executeUpdate();

			// Close connection
			stmt.close();
			conn.close();

			if (i > 0) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			result = false;
		}
		return result;
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

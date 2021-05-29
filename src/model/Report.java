package model;

import java.util.Date;
import model.Report;

public class Report {
	public int id;
	public int studentId;
	public int classId;
	public int subjectId;
	public String subjectName;
	public float dailyExam;
	public float fifteenExam;
	public float onePeriodExam;
	public float middleSemester;
	public float finalSemester;
	public Date reportYear;
	public int semeter;
	public String className;
	public String firstName;
	public String lastName;
	public String academicYearStart;
	
	public Report() {
		
	}
	
	public Report(int id, int studentId, int classId, int subjectId, String subjectName, float dailyExam, float fifteenExam,
			float onePeriodExam, float middleSemester, float finalSemester, 
			Date reportYear, int semeter, String className, String firstName, String lastName, String academicYearStar) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.classId = classId;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.dailyExam = dailyExam;
		this.fifteenExam = fifteenExam;
		this.onePeriodExam = onePeriodExam;
		this.middleSemester = middleSemester;
		this.finalSemester = finalSemester;
		this.reportYear = reportYear;
		this.semeter = semeter;
		this.className = className;
		this.firstName = firstName;
		this.lastName = lastName;
		this.academicYearStart = academicYearStar;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public float getDailyExam() {
		return dailyExam;
	}
	public void setDailyExam(float dailyExam) {
		this.dailyExam = dailyExam;
	}
	public float getFifteenExam() {
		return fifteenExam;
	}
	public void setFifteenExam(float fifteenExam) {
		this.fifteenExam = fifteenExam;
	}
	public float getOnePeriodExam() {
		return onePeriodExam;
	}
	public void setOnePeriodExam(float onePeriodExam) {
		this.onePeriodExam = onePeriodExam;
	}
	public float getMiddleSemester() {
		return middleSemester;
	}
	public void setMiddleSemester(float middleSemester) {
		this.middleSemester = middleSemester;
	}
	public float getFinalSemester() {
		return finalSemester;
	}
	public void setFinalSemester(float finalSemester) {
		this.finalSemester = finalSemester;
	}
	public Date getReportYear() {
		return reportYear;
	}
	public void setReportYear(Date reportYear) {
		this.reportYear = reportYear;
	}
	public int getSemeter() {
		return semeter;
	}
	public void setSemeter(int semeter) {
		this.semeter = semeter;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAcademicYearStart() {
		return academicYearStart;
	}
	public void setAcademicYearStart(String academicYearStart) {
		this.academicYearStart = academicYearStart;
	}
	
	
}

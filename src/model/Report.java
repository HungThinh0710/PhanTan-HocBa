package model;

import java.util.Date;
import model.Report;

public class Report {
	public int id;
	public int studentId;
	public int classId;
	public int subjectId;
	public float dailyExam;
	public float fifteenExam;
	public float onePeriodExam;
	public float middleSemester;
	public float finalSemester;
	public Date reportYear;
	public int semeter;
	
	
	
	public Report(int id, int studentId, int classId, int subjectId, float dailyExam, float fifteenExam,
			float onePeriodExam, float middleSemester, float finalSemester, Date reportYear, int semeter) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.classId = classId;
		this.subjectId = subjectId;
		this.dailyExam = dailyExam;
		this.fifteenExam = fifteenExam;
		this.onePeriodExam = onePeriodExam;
		this.middleSemester = middleSemester;
		this.finalSemester = finalSemester;
		this.reportYear = reportYear;
		this.semeter = semeter;
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
	
	
}

package model;

import java.io.Serializable;

public class Student implements Serializable {
	public int id;
	public String firstName;
	public String lastName;
	public String address;
	public String phoneNumber;
	public String gender;
	public String homeTown;
	public String schoolId;
	public String academicYearStart;
	
	public Student() {
		
	}
	public Student(int id, String firstName, String lastName, String address, String phoneNumber, String gender, String homeTown, String schoolId, String academicYearStart) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.homeTown = homeTown;
		this.schoolId = schoolId;
		this.academicYearStart = academicYearStart;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getAcademicYearStart() {
		return academicYearStart;
	}
	public void setAcademicYearStart(String academicYearStart) {
		this.academicYearStart = academicYearStart;
	}
	
}

package model;

import java.util.Date;

public class Teacher {
	public int ID;
	public String firstName;
	public String lastName;
	public Date dob;
	public String phoneNumber;
	public String gender;
	public String homeTown;
	public int schoolId;
	public String schoolName; //other table
	public String subjectName; //other table
	
	public Teacher() {
		
	}

	public Teacher(int iD, String firstName, String lastName, Date dob, String phoneNumber, String gender,
			String homeTown, int schoolId, String schoolName, String subjectName) {
		super();
		ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.homeTown = homeTown;
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.subjectName = subjectName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}
	
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
}

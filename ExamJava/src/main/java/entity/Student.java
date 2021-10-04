package entity;

import java.time.LocalDate;

public class Student {
	private int stuId;
	private String fullName;
	private Boolean gender;
	private LocalDate birthday;
	private String email;

	public Student() {

	}

	public Student(int stuId, String fullName, Boolean gender, LocalDate birthday, String email) {
		this.stuId = stuId;
		this.fullName = fullName;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return  + stuId + "\t" +  fullName + "\t" +  gender + "\t" +  birthday
				+ "\t" +  email + "";
	}




}

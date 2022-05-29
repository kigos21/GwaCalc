package com.user;

public class UserStudent {
	private String username;
	private String password;
	private String name;
	private String section;
	private String programCourse;
	private int referenceNo;
	//private ArrayList<Course> courses; 
	
	public UserStudent(String username, String password) {
		setUsername(username);
		setPassword(password);
	}
	
	public UserStudent(String name, String section, String programCourse, int referenceNo) {
		setName(name);
		setSection(section);
		setProgramCourse(programCourse);
		setReferenceNo(referenceNo);
	}
	
	public UserStudent() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getReferenceNo() {
		return referenceNo;
	}
	
	public void setReferenceNo(int referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getProgramCourse() {
		return programCourse;
	}

	public void setProgramCourse(String programCourse) {
		this.programCourse = programCourse;
	}
}

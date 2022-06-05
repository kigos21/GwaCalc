package com.user;

import java.util.ArrayList;

public class UserStudent {
	
	private String username;
	private String password;
	private String name;
	private String section;
	private String programCourse;
	private int referenceNo;
	private ArrayList<String> usernames; 
	private ArrayList<String> passwords; 
	
	public UserStudent(String username, String password) {
		setUsername(username);
		setPassword(password);
	}
	
	public UserStudent(ArrayList<String> usernames, ArrayList<String> passwords) {
		setUsernames(usernames);
		setPasswords(passwords);
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
	
	public ArrayList<String> getUsernames() {
		return usernames;
	}

	public void setUsernames(ArrayList<String> usernames) {
		this.usernames = usernames;
	}

	public ArrayList<String> getPasswords() {
		return passwords;
	}

	public void setPasswords(ArrayList<String> passwords) {
		this.passwords = passwords;
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

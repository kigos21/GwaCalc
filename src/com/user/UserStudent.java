package com.user;


public class UserStudent {
	
	private String username;
	private String password;
	
	public UserStudent(String username, String password) {
		setUsername(username);
		setPassword(password);
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

}

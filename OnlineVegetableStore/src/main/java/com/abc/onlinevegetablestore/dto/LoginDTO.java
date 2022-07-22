package com.abc.onlinevegetablestore.dto;

public class LoginDTO {
	String username;
	String password;
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}


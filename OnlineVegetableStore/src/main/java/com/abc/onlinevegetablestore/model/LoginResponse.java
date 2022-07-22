package com.abc.onlinevegetablestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name = "Login_Details")
	public class LoginResponse {
		

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int id;
		@Column(name ="User_Name")
		String username;
		@Column(name ="Password")
		String password;
		
		@Column(name ="Role")
		String role;
		
		@Column(name ="Status")
		String status;
		public LoginResponse(String username, String password, String role, String status, int id) {
			super();
			this.username = username;
			this.password = password;
			this.role = role;
			this.status = status;
			this.id=id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public int getid() {
			return id;
		}
		public void setid(int id) {
			this.id = id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String isStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		
	}



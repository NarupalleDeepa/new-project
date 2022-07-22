package com.abc.onlinevegetablestore.dto;


import java.util.Objects;

public class LoginResponseDTO {
		String username;
		String password;
		String role;
		boolean status;
		public LoginResponseDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public LoginResponseDTO(String username, String password, String role, boolean status) {
			super();
			this.username = username;
			this.password = password;
			this.role = role;
			this.status = status;
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
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		@Override
		public int hashCode() {
			return Objects.hash(password, role, status, username);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LoginResponseDTO other = (LoginResponseDTO) obj;
			return Objects.equals(password, other.password) && Objects.equals(role, other.role)
					&& status == other.status && Objects.equals(username, other.username);
		}
		@Override
		public String toString() {
			return "LoginResponseDTO [username=" + username + ", password=" + password + ", role=" + role + ", status="
					+ status + "]";
		}
		public void setStatus(String string) {
			// TODO Auto-generated method stub
			
		}
		
}


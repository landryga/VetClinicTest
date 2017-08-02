package com.vetClinic.admin;

public class UserMaintainer {

	private String username;
	private String email;
	private boolean is_admin;
	private String password;
	

	private int id;
	
	public UserMaintainer() {
		
	}
	
	
	public UserMaintainer(String username, boolean is_admin) {
		super();
		this.username = username;
		this.is_admin = is_admin;
	}
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public boolean getIs_admin() {
		return is_admin;
	}


	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
}

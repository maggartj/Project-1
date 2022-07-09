package com.project1.dao;

public interface AuthenticationDAO {
	
	public boolean authenticateUser(String username, String password);
	public boolean check();

}

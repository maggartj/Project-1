package com.project1.dao;

import java.sql.SQLException;

import io.javalin.http.Context;

public interface RequestDAO {
	
	public void getRequests(Context ctx, String username) throws SQLException;
	public void getRequestHistory(Context ctx, String username) throws SQLException;
	public void getAllRequests(Context ctx) throws SQLException;
	public Context postRequest(Context ctx) throws SQLException;
	public void updateHistory(Context ctx) throws SQLException;
	public void approveRequest(Context ctx, String username) throws SQLException;
	public void denyRequest(Context ctx, String username) throws SQLException;
	public void history(Context ctx) throws SQLException;

}

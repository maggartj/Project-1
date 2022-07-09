package com.project1.service;

import com.project1.dao.AuthenticationDAOImpl;
import com.project1.util.Prometheus;

import io.javalin.http.Context;

public class AuthenticationServiceImpl implements AuthenticationService{
	
	public AuthenticationServiceImpl() {
		super();
	}

	AuthenticationDAOImpl authDao = new AuthenticationDAOImpl();
	public void login(Context ctx) {
	
	Prometheus.counter();	//updates prometheus for login attempts
	String username = ctx.formParam("username");
	String password = ctx.formParam("password");
	
		if(authDao.authenticateUser(username, password)) {
			ctx.sessionAttribute("username", username);
			ctx.sessionAttribute("password", password);
			
			ctx.status(201);
			} else {
				ctx.status(403);
			}
	}
	
}

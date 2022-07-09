package com.project1.controller;

import com.project1.service.AuthenticationService;
import com.project1.service.AuthenticationServiceImpl;
import com.project1.service.RequestService;
import com.project1.service.RequestServiceImpl;
import io.javalin.http.Context;

public class RequestController implements RequestService, AuthenticationService{

	public RequestController() {
		super();
	}
	
	RequestServiceImpl req = new RequestServiceImpl();
	AuthenticationServiceImpl auth = new AuthenticationServiceImpl();
	
	//-----------------------------------login
	public void login(Context ctx) {
		
		auth.login(ctx);
	}
	
	//-----------------------------------admin
	public void getAllRequests(Context ctx){
		

		req.getAllRequests(ctx);
		
	}
	
	public void requestApproval(Context ctx) {
		

		req.requestApproval(ctx);
		
	}
	
	public void requestDenial(Context ctx) {
		
		req.requestDenial(ctx);
		
	}
	
	public void history(Context ctx) {
		
		req.history(ctx);
	}
	
	//-----------------------------------------------employee
	public void getPending(Context ctx){
		
		
		req.getPending(ctx);
		
	}
	
	public void getHistory(Context ctx){
		
		req.getHistory(ctx);
	}
	
	public void postRequest(Context ctx){
		
		req.postRequest(ctx);
		
	}

	
}

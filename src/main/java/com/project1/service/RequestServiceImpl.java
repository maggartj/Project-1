package com.project1.service;

import java.sql.SQLException;

import com.project1.dao.RequestDAOImpl;

import io.javalin.http.Context;

public class RequestServiceImpl implements RequestService{
	
	public RequestServiceImpl() {
		super();
	}
	
	RequestDAOImpl reqDao = new RequestDAOImpl();
	//-----------------------------------admin
		public void getAllRequests(Context ctx){
			
			
			try {
				reqDao.getAllRequests(ctx);
				ctx.status(200);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		public void requestApproval(Context ctx) {
			
			String user = ctx.formParam("username");
		
			try {
				reqDao.approveRequest(ctx, user);
				ctx.status(201);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		public void requestDenial(Context ctx) {
			
			String user = ctx.formParam("username");
			try {
				reqDao.denyRequest(ctx, user);
				ctx.status(201);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		public void history(Context ctx) {

			try {
				reqDao.history(ctx);
				ctx.status(201);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//-----------------------------------------------employee
		public void getPending(Context ctx){
			
			String user = ctx.formParam("username");
			String check = ctx.cookieStore("username"); 
			
			if(user.equalsIgnoreCase(check)) {

				 try {
					reqDao.getRequests(ctx, check);
					ctx.status(200);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				 
			}
		}
		
		public void getHistory(Context ctx){
			
			String user = ctx.formParam("username");
			String check = ctx.cookieStore("username");
			if(user.equalsIgnoreCase(check)) {

				 try {
					reqDao.getRequestHistory(ctx, check);
					ctx.status(200);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				 
			}
		}
		
		public void postRequest(Context ctx){

			try {
				reqDao.postRequest(ctx);
				ctx.status(201);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		
}



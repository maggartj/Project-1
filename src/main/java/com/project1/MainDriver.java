package com.project1;
import java.io.File;

import com.project1.controller.RequestMapping;
import com.project1.util.Prometheus;

import io.javalin.Javalin;
import io.javalin.plugin.metrics.MicrometerPlugin;



public class MainDriver {
	

	


	public static void main(String...args) {


		Javalin app = Javalin.create( config -> {
			config.registerPlugin(new MicrometerPlugin(Prometheus.registry));
				}
				).start(7070);
		
		 RequestMapping.configureRoutes(app);
	
		
		
		 
			
		 app.get("/prometheus", ctx -> {
				 
				 ctx.result(Prometheus.registry.scrape());
			 });
		
	}
	
	 

}

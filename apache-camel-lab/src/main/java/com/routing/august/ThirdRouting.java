package com.routing.august;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;


public class ThirdRouting {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		

		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				
			/*	from("file:src/main/data/in?noop=true")
				.choice()
				.when(simple("${file:ext} == 'txt'"))
				.to("file:src/main/data/out/uk")
				.when(simple("${file:ext} == 'xml'"))
				.to("file:src/main/data/out/others");*/
				
			//backup prog
				from("file:src/main/data/in?noop=true&move=D:/softwares/backup${date:now:yyyyMMdd}/${file:name.noext}.xml&recursive=false&sortBy=reverse:file:name")
				
				.log(" reverse message ${body}")
				.to("file:src/main/data/out/others");
				
			}
		});

		context.start();
		Thread.sleep(50000);
	}

	}


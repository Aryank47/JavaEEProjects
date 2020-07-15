package com.netcracker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class DateAndTime extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		LocalDateTime ldt=LocalDateTime.now();
		PrintWriter out=response.getWriter();
		out.print("Date is: "+ldt.getDayOfMonth()+":"+ldt.getMonthValue()+":"+ldt.getYear()+"<br>");
		out.print("Time  is: "+ldt.getHour()+":"+ldt.getMinute()+":"+ldt.getSecond());
		
	}

}

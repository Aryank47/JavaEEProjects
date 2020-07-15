package com.netcracker.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Refresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	      response.setIntHeader("Refresh", 5);
	 
	     
	      Calendar calendar = new GregorianCalendar();
	      String am_pm;
	      int hour = calendar.get(Calendar.HOUR);
	      int minute = calendar.get(Calendar.MINUTE);
	      int second = calendar.get(Calendar.SECOND);
	      
	      if(calendar.get(Calendar.AM_PM) == 0)
	        am_pm = "AM";
	      else
	        am_pm = "PM";
	 
	      String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
	      
	      request.setAttribute("time", CT);
	      RequestDispatcher link=request.getRequestDispatcher("AutoRefresh.jsp");
	      link.forward(request, response);
	      
	      
	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

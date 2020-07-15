package com.netcracker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String mime=request.getContentType();
		Locale lr=request.getLocale();
		int length=request.getContentLength();
		PrintWriter out=response.getWriter();
		
		
		  if(username.equalsIgnoreCase("aryan")& password.equalsIgnoreCase("123")) {
			  out.println("Success"+"<br>");
			  out.println(mime+"<br>"+lr+"<br>"+length);
		  
		  } else { 
			 
			 response.sendRedirect("Failure.html"); 
			  
		  }
		 
	}

}

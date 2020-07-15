package com.netcracker.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netcracker.customexception.DatabaseException;
import com.netcracker.dto.User;
import com.netcracker.service.UserServiceImpl;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<User> list;
	UserServiceImpl userServ;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		list = new ArrayList<User>();
		userServ = new UserServiceImpl();
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String useraction=request.getParameter("action");
		if(useraction!=null) {
			if(useraction.equals("SHOW")) {
				try {
					list = userServ.getAll();
					RequestDispatcher rd = request.getRequestDispatcher("ShowDetails.jsp");
					request.setAttribute("empall", list);
					rd.forward(request, response);
				} catch (DatabaseException e) {
					request.setAttribute("exception", e);
					RequestDispatcher link=request.getRequestDispatcher("ErrorPage.jsp");
					link.forward(request, response);
				}
			}
			else if(useraction.equalsIgnoreCase("register")) {
				User user = new User();
				user.setFirstName(request.getParameter("firstName"));
				user.setLastName(request.getParameter("lastName"));
				user.setPassword(request.getParameter("password"));
				user.setGender(request.getParameter("gender"));
				String[] skills=request.getParameterValues("skills");
				String skillsStr = String.join(",", skills);
				user.setSkills(skillsStr);
				user.setCity(request.getParameter("city"));
				
				boolean flag = false;
				
				try {
					flag = userServ.registerUser(user);
				} catch (DatabaseException e) {
					request.setAttribute("exception", e);
					RequestDispatcher link=request.getRequestDispatcher("ErrorPage.jsp");
					link.forward(request, response);
				}
				
				if(flag == true) {
					response.sendRedirect("success.html");
				}
				else {
					response.sendRedirect("fail.html");
				}
			}
			else {
				response.sendRedirect("HomePage.html");
			}
		}
		
		  else { response.sendRedirect("HomePage.html"); }
		 
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

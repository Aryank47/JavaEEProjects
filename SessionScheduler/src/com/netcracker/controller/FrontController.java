package com.netcracker.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netcracker.customexception.DatabaseException;
import com.netcracker.dto.SessionScheduler;
import com.netcracker.service.SessionSchedulerService;
import com.netcracker.service.SessionSchedulerServiceImpl;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SessionSchedulerService ssService;
	SessionScheduler ss;
	
	public void init(ServletConfig config) throws ServletException {
		ssService=new SessionSchedulerServiceImpl();
		ss=new SessionScheduler();
	}

	
	public void destroy() {
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action=request.getParameter("action");
			if(action!=null) {
				if(action.equalsIgnoreCase("GETALL")) {
					try {
						List<SessionScheduler> ss=ssService.getAll();
						request.setAttribute("list", ss);
						RequestDispatcher link=request.getRequestDispatcher("displayall.jsp");
						link.forward(request, response);
					} catch (DatabaseException e) {
						request.setAttribute("exception", e);
						RequestDispatcher link=request.getRequestDispatcher("ErrorPage.jsp");
						link.forward(request, response);
					}
					
				}
				else if(action.equalsIgnoreCase("update")) {
					int duration=Integer.parseInt(request.getParameter("duration"));
					String faculty=request.getParameter("faculty");
					String mode1=request.getParameter("Role");
					String name=request.getParameter("name");
					int id=Integer.parseInt(request.getParameter("id1"));
					
					ss.setId(id);
					ss.setName(name);
					ss.setFaculty(faculty);
					ss.setDuration(duration);
					ss.setMode1(mode1);
					
					try {
						int count=ssService.update(ss);
						if(count>0) {
							List<SessionScheduler> ss=ssService.getAll();
							request.setAttribute("list", ss);
							RequestDispatcher link=request.getRequestDispatcher("displayall.jsp");
							link.forward(request, response);
						}
						else {
							response.sendRedirect("Failure.jsp");
						}
					} catch (DatabaseException e) {
						request.setAttribute("exception", e);
						RequestDispatcher link=request.getRequestDispatcher("ErrorPage.jsp");
						link.forward(request, response);
					}
				}
			}
			else {
				response.sendRedirect("Error.jsp");
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

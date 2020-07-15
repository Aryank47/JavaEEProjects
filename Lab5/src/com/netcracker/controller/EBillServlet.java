package com.netcracker.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.netcracker.customexception.DatabaseException;
import com.netcracker.dto.BillDetails;
import com.netcracker.dto.ConsumerData;
import com.netcracker.dto.Consumers;
import com.netcracker.services.ConsumerServices;
import com.netcracker.services.ConsumerServicesImpl;

public class EBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HttpSession mySession;
	ConsumerServices consumerServices;
	BillDetails billDetails;
	ConsumerData consumerData;
	Consumers consumer;
	
	public void init(ServletConfig config) throws ServletException {
		
		consumerServices = new ConsumerServicesImpl();
		consumerData=new ConsumerData();
	}

	public void destroy() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action!=null) {
			if(action.equalsIgnoreCase("register")) {
				String newUsername = request.getParameter("username");
				String password = request.getParameter("password");
				consumerData.setUsername(newUsername);
				consumerData.setPassword(password);
				try {
					int count=consumerServices.registerUser(consumerData);
					if(count >0) {
						response.sendRedirect("RegisterConsumer.jsp");
					}
				} catch (DatabaseException e) {
					mySession.setAttribute("exception", e);
					RequestDispatcher link=request.getRequestDispatcher("ErrorPage.jsp");
					link.forward(request, response);
				}
				
			}
			else if(action.equalsIgnoreCase("getall")) {
				try {
					List<Consumers> con=consumerServices.getAllConsumers();
					mySession.setAttribute("list", con);
					RequestDispatcher link=request.getRequestDispatcher("DisplayAllConsumes.jsp");
					link.forward(request, response);
				} catch (DatabaseException e) {
					mySession.setAttribute("exception", e);
					RequestDispatcher link=request.getRequestDispatcher("ErrorPage.jsp");
					link.forward(request, response);
				}
			}
			else if(action.equalsIgnoreCase("show")) {
				
				try {
					List<BillDetails> bill=consumerServices.getBillDetails(Long.parseLong(request.getParameter("consumerNo")));
					mySession.setAttribute("bill", bill);
					RequestDispatcher link=request.getRequestDispatcher("DisplayBillDetails.jsp");
					link.forward(request, response);
				} catch (DatabaseException e) {
					request.setAttribute("exception", e);
					RequestDispatcher link=request.getRequestDispatcher("ErrorPage.jsp");
					link.forward(request, response);
				}
			}
			
			else if(action.equalsIgnoreCase("search")) {
				long consumerNo=Long.parseLong(request.getParameter("consumerno"));
				try {
					Consumers con=consumerServices.getConsumerDetails(consumerNo);
					mySession.setAttribute("consumer", con);
					RequestDispatcher link=request.getRequestDispatcher("DisplayConsumer.jsp");
					link.forward(request, response);
				} catch (DatabaseException e) {
					mySession.setAttribute("exception", e);
					RequestDispatcher link=request.getRequestDispatcher("ErrorPage.jsp");
					link.forward(request, response);
				}
			}
			else if(action.equalsIgnoreCase("logout")) {
				mySession.invalidate();
			}
			else if(action.equalsIgnoreCase("submit")) {
				String name=request.getParameter("name");
				String address=request.getParameter("address");
				consumer=new Consumers(name, address);
				try {
					int count=consumerServices.registerConsumer(consumer);
					if(count>0) {
						response.sendRedirect("Login.jsp");
					}
				} catch (DatabaseException e) {
					mySession.setAttribute("exception", e);
					RequestDispatcher link=request.getRequestDispatcher("ErrorPage.jsp");
					link.forward(request, response);
				}
				
			}
			else if(action.equalsIgnoreCase("log in")) {
				
				  String username = request.getParameter("username");
				
				  String password =request.getParameter("password"); 
				  
				  
				  consumerData.setUsername(username);
				  consumerData.setPassword(password);
				  
				  System.out.println(consumerData.getUsername());
				  System.out.println(consumerData.getPassword());
				try {
					if(consumerServices.authentication(consumerData)) {
						mySession=request.getSession();
						mySession.setAttribute("username", username);
						response.sendRedirect("Home.jsp");
					}
					else {
						response.sendRedirect("Failure.html");
					}
				} catch (DatabaseException | IOException e) {
					mySession.setAttribute("exception", e);
					RequestDispatcher link=request.getRequestDispatcher("ErrorPage.jsp");
					link.forward(request, response);
				}
			}
			else if(action.equalsIgnoreCase("calculate bill")) {
				
				long consumerNo = Long.parseLong(request.getParameter("consumerno"));
				float lastMonReading = Float.parseFloat(request.getParameter("lastmonreading"));
				float currentMonReading = Float.parseFloat(request.getParameter("currentmonreading"));
				
				
				try {
					int flag = consumerServices.verifyConsumer(consumerNo);
					if(flag>0) {
						
						int fixedCharge = 100;
						float unitsConsumed = lastMonReading-currentMonReading;
						float netAmount = unitsConsumed*1.15f+fixedCharge;
						
						
						billDetails=new BillDetails(consumerNo, currentMonReading, unitsConsumed, netAmount);
						int count=consumerServices.insertBill(billDetails);
						mySession.setAttribute("count", count);
						 
						
						mySession.setAttribute("billDetails", billDetails);
					
						RequestDispatcher link=request.getRequestDispatcher("DisplayDetails.jsp");
						link.forward(request, response);
						
					}
					else {
						
						response.sendRedirect("Error.html");
						
					}
				} catch (DatabaseException e) {
					mySession.setAttribute("exception", e);
					RequestDispatcher link=request.getRequestDispatcher("ErrorPage.jsp");
					link.forward(request, response);
				}
				
			}
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

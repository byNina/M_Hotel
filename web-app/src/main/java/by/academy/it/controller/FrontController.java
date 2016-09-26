package by.academy.it.controller;

import by.academy.it.commands.Command;
import by.academy.it.commands.factory.CommandFactory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class Test01
 */

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FrontController() {
        super();
           }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      String page = null;
		
		CommandFactory commandFactory = CommandFactory.INSTANCE;
		Command command = commandFactory.defineCommand(request);
		page = command.execute(request);
		String errorpage = "/jsp/errorpage.jsp";
		if(page != null){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
			dispatcher.forward(request, response);
		}
		else{
		  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(errorpage);
			dispatcher.forward(request, response);
		}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet");
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  System.out.println("in doPost");	
	  processRequest(request, response);
	 
	  	}

}

package by.academy.it.tests;



import by.academy.it.commands.AbstractCommand;

import javax.servlet.http.HttpServletRequest;



public class Error extends AbstractCommand {
 

  public String execute(HttpServletRequest request) {
	 String page ="/jsp/errorpage.jsp";
	 return page;
  }
	 

}

package by.academy.it.tests;



import by.academy.it.commands.AbstractCommand;

import javax.servlet.http.HttpServletRequest;



public class Test extends AbstractCommand {

  public String execute(HttpServletRequest request) {
	String page = "/jsp/test.jsp";
	return page;
  }
}

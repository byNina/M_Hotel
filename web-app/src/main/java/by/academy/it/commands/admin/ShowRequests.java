/**
 * 
 */
package by.academy.it.commands.admin;

import by.academy.it.beans.User;
import by.academy.it.constants.Parameters;
import by.academy.it.beans.Request;
import by.academy.it.commands.AbstractCommand;
import by.academy.it.constants.ConfigsConstants;
import by.academy.it.dao.RequestDAO;
import by.academy.it.managers.ConfigurationManager;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



/**
 * @author shevchenko
 *
 */
public class ShowRequests extends AbstractCommand {

  @Override
  public String execute(HttpServletRequest request) {
	  	String page = null;
	User user = null;
	HttpSession session = request.getSession();
 	List<Request> requests;
	try {
	  user = (User) session.getAttribute(Parameters.USER);
	  requests = RequestDAO.INSTANCE.findAll();
	  System.out.println("DAO done");
	  session.setAttribute(Parameters.REQUESTS, requests);
	} catch (SQLException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	}
	page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REQUESTS);
	return page;
  }
}
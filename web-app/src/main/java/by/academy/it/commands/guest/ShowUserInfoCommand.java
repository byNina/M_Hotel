/**
 * 
 */
package by.academy.it.commands.guest;

import by.academy.it.beans.User;
import by.academy.it.constants.Parameters;
import by.academy.it.commands.AbstractCommand;
import by.academy.it.constants.AccessLevel;
import by.academy.it.constants.ConfigsConstants;
import by.academy.it.dao.UserDAO;
import by.academy.it.managers.ConfigurationManager;
import org.apache.log4j.Logger;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



/**
 * @author shevchenko
 *
 */
public class ShowUserInfoCommand extends AbstractCommand {
	protected Logger log = Logger.getLogger(getClass());

  @Override
  public String execute(HttpServletRequest request) {
	  System.out.println("in ShowUserInfoCom");
	String page = null;
	HttpSession session = request.getSession();

	AccessLevel accessLvl = (AccessLevel) session.getAttribute(Parameters.ACCESS_LEVEL_ATTRIBUTE);

	if (accessLvl == AccessLevel.ADMIN) {
	  String id = (String) request.getParameter(Parameters.USER_ID);
		System.out.println("id" + id);
	  User user;
	  try {
		user = UserDAO.INSTANCE.getUserById(id);
		System.out.println("DAO done" + user);
		session.setAttribute(Parameters.USER_INFO, user);
	  } catch (SQLException e) {
		  System.out.println("Error getting user by Id");
		  log.error("Error getting user by Id");
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	  page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_SHOW_INFO);

	} else {
	  page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
	  session.invalidate();
	}
	return page;
  }

}

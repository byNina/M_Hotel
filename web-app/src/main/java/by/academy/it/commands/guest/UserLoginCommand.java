package by.academy.it.commands.guest;

import by.academy.it.beans.User;
import by.academy.it.constants.Parameters;
import by.academy.it.commands.AbstractCommand;
import by.academy.it.constants.AccessLevel;
import by.academy.it.constants.ConfigsConstants;
import by.academy.it.constants.MessageConstants;
import by.academy.it.dao.UserDAO;
import by.academy.it.managers.ConfigurationManager;
import by.academy.it.managers.MessageManager;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



public class UserLoginCommand extends AbstractCommand {

  @Override
  public String execute(HttpServletRequest request) {
	System.out.println("Register");
	String page = null;
	String login = request.getParameter(Parameters.LOGIN);
	String password = request.getParameter(Parameters.PASSWORD);
	try {
	  if (UserDAO.INSTANCE.isAuthorized(login, password)) {
		HttpSession session = request.getSession();
		User user = UserDAO.INSTANCE.getUserByLogin(login);
		AccessLevel accessLevel = UserDAO.INSTANCE.checkAccessLevel(login);
		session.setAttribute(Parameters.ACCESS_LEVEL_ATTRIBUTE, accessLevel);
		session.setAttribute(Parameters.USER, user);
		switch (accessLevel) {
		case ADMIN:
		  page = "/jsp/main.jsp";
		  session.setAttribute(Parameters.SIDE_BAR, ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_SIDE_BAR));
		  break;
		case USER:
		  page = "/jsp/main.jsp";
		  session.setAttribute(Parameters.SIDE_BAR, ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_SIDE_BAR));
		  break;
		default:
		}
	  } else {
		page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
		request.setAttribute(Parameters.ERROR_LOGIN_OR_PASSWORD,
			MessageManager.INSTANCE.getProperty(MessageConstants.WRONG_LOGIN_OR_PASSWORD));
	  }
	} catch (SQLException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	}
	return page;
  }

}

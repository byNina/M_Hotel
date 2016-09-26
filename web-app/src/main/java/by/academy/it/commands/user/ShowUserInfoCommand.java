///**
// *
// */
//package by.academy.it.commands.user;
//
//import java.sql.SQLException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import User;
//
//import AbstractCommand;
//import ConfigsConstants;
//import Parameters;
//import UserDAO;
//import ConfigurationManager;
//
//
///**
// * @author shevchenko
// *
// */
//public class ShowUserInfoCommand extends AbstractCommand {
//
//
//  public String execute(HttpServletRequest request) {
//	String page = null;
//	HttpSession session = request.getSession();
//
//	System.out.println("Get session");
//
//	String id = (String)request.getParameter(Parameters.USER_ID);
////	String id = "1";
//	User user;
//	try {
//	  user = UserDAO.INSTANCE.getUserById(id);
//	  System.out.println("DAO done");
//	  session.setAttribute(Parameters.USER_INFO, user);
//	} catch (SQLException e) {
//	  // TODO Auto-generated catch block
//	  e.printStackTrace();
//	}
//	page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_SHOW_INFO);
//	return page;
//  }
//
//}

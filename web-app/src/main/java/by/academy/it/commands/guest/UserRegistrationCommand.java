/**
 * 
 */
package by.academy.it.commands.guest;

import by.academy.it.beans.User;
import by.academy.it.constants.MessageConstants;
import by.academy.it.constants.Parameters;
import by.academy.it.commands.AbstractCommand;
import by.academy.it.constants.ConfigsConstants;
import by.academy.it.dao.UserDAO;
import by.academy.it.managers.MessageManager;
import by.academy.it.managers.ConfigurationManager;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;




/**
 * @author shevchenko
 *
 */
public class UserRegistrationCommand extends AbstractCommand {

  private static String login;
  private static String password;
  private static String userInfo;
  private static int accessLevel;

  /*
   * (non-Javadoc)
   * 
   * @see by.pvt.shevchenko.commands.Command#execute(javax.servlet.http.
   * HttpServletRequest)
   */
  @Override
  public String execute(HttpServletRequest request) {
	String page = null;

	login = request.getParameter(Parameters.LOGIN);
	password = request.getParameter(Parameters.PASSWORD);
	userInfo = request.getParameter(Parameters.USER_INFO);
	
	try{
		if(areFieldsFilled()){	
		  if(isNewUser(login)){
			registrate();
			page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.MAIN_PAGE_PATH);
			request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
		  }
			else{
				page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
				request.setAttribute(Parameters.ERROR_USER_EXSISTS, MessageManager.INSTANCE.getProperty(MessageConstants.USER_EXSISTS));
			}
		}
		else{
			request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
			page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
		}
	
	} catch (Exception e){
			System.out.println("Error");
			}
		  
	
	return page;
  }

  private void registrate() throws SQLException {

	User user = new User();
	accessLevel = 0;
	user.setLogin(login);
	user.setPassword(password);
	user.setUserInfo(userInfo);
	user.setAccountType(accessLevel);
	UserDAO.INSTANCE.createEntity(user);
  }

  private boolean areFieldsFilled() {
	boolean isFilled = false;
	if (login !=null && password!=null && userInfo!=null) {
	  isFilled = true;
	}
	return isFilled;
  }

  private boolean isNewUser(String login) throws SQLException {
	boolean isNew = false;
	if ((UserDAO.INSTANCE.getUserByLogin(login)== null)) {
	  isNew = true;
	}
	return isNew;
  }
}

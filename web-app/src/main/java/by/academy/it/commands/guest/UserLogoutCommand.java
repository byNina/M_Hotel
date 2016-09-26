/**
 * 
 */
package by.academy.it.commands.guest;

import by.academy.it.constants.Parameters;
import by.academy.it.commands.AbstractCommand;
import by.academy.it.constants.AccessLevel;
import by.academy.it.constants.ConfigsConstants;
import by.academy.it.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



/**
 * @author shevchenko
 *
 */
public class UserLogoutCommand extends AbstractCommand {

  @Override
  public String execute(HttpServletRequest request) {
	String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
	String sideBar = (String) ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.GUEST_SIDE_BAR);
	request.getSession().invalidate();
	HttpSession session = request.getSession();
	AccessLevel accessLevel = AccessLevel.GUEST;
	session.setAttribute(Parameters.ACCESS_LEVEL_ATTRIBUTE, accessLevel);
	session.setAttribute(Parameters.SIDE_BAR, sideBar);
	return page;
  }
}

/**
 * 
 */
package by.academy.it.commands.guest;

import by.academy.it.commands.AbstractCommand;
import by.academy.it.constants.ConfigsConstants;
import by.academy.it.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;




/**
 * @author shevchenko
 *
 */
public class GoToRegistrationCommand extends AbstractCommand {

  /* (non-Javadoc)
   * @see by.pvt.shevchenko.commands.Command#execute(javax.servlet.http.HttpServletRequest)
   */
  @Override
  public String execute(HttpServletRequest request) {
	String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
	return page;
}

}


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
public class ShowHotelInfo extends AbstractCommand {

  @Override
  public String execute(HttpServletRequest request) {
	String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.HOTEL_INFO_PATH);
	return page;
	  }

}
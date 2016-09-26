package by.academy.it.commands.guest;

import by.academy.it.commands.AbstractCommand;
import by.academy.it.constants.ConfigsConstants;
import by.academy.it.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;



/**
 * @author shevchenko
 * @version 1.0
 *
 */

public class GoBackCommand extends AbstractCommand {

  @Override
  public String execute(HttpServletRequest request) {
	String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
	return page;
	  }

}

/**
 * 
 */
package by.academy.it.commands.language;



import by.academy.it.commands.AbstractCommand;
import by.academy.it.constants.ConfigsConstants;
import by.academy.it.constants.Parameters;
import by.academy.it.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



/**
 * @author shevchenko
 *
 */
public class SetLanguageCommand extends AbstractCommand {
  private final String BASENAME = "locale_";

  /*
   * (non-Javadoc)
   * 
   * @see by.pvt.shevchenko.commands.Command#execute(javax.servlet.http.
   * HttpServletRequest)
   */
  @Override
  public String execute(HttpServletRequest request) {
	String page = null;
	
	String lang = request.getParameter(Parameters.LANG);
	HttpSession session = request.getSession();
	session.setAttribute(Parameters.SESSION_LOCALE_ATTRIBUTE, BASENAME + lang);
	page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
	return page;
  }

}

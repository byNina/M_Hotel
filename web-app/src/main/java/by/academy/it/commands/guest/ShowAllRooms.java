/**
 * 
 */
package by.academy.it.commands.guest;

import by.academy.it.constants.Parameters;
import by.academy.it.beans.ApartmentType;
import by.academy.it.commands.AbstractCommand;
import by.academy.it.constants.ConfigsConstants;
import by.academy.it.dao.ApartmentTypeDAO;
import by.academy.it.managers.ConfigurationManager;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



/**
 * @author shevchenko
 *
 */
public class ShowAllRooms extends AbstractCommand {

  @Override
  public String execute(HttpServletRequest request) {
	String page = null;
	HttpSession session = request.getSession();

	List<ApartmentType> apartmentTypes;
	try {
	  apartmentTypes = ApartmentTypeDAO.INSTANCE.findAll();
	  System.out.println("DAO done");
	  session.setAttribute(Parameters.APARTMENT_TYPES, apartmentTypes);
	} catch (SQLException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	}
	page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.APARTMENT_TYPES);
	return page;
  }
}
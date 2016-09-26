/**
 * 
 */
package by.academy.it.commands.user;


import by.academy.it.beans.User;
import by.academy.it.constants.MessageConstants;
import by.academy.it.constants.Parameters;
import by.academy.it.dao.RequestDAO;
import by.academy.it.beans.Request;
import by.academy.it.commands.AbstractCommand;
import by.academy.it.constants.ConfigsConstants;
import by.academy.it.managers.MessageManager;
import by.academy.it.managers.ConfigurationManager;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author shevchenko
 *
 */
public class CreateNewRequest extends AbstractCommand {
  private static Date checkIn;
  private static Date checkOut;
  private static int adults;
  private static User user;

  @Override
  public String execute(HttpServletRequest request) {
	String page = null;

	try {
	  SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	  checkIn = format.parse(request.getParameter(Parameters.CHECKIN));
	  checkOut = format.parse(request.getParameter(Parameters.CHECKOUT));
	  adults = Integer.parseInt(request.getParameter(Parameters.ADULTS));
	  HttpSession session = request.getSession();
	  user = (User) session.getAttribute(Parameters.USER);
	  System.out.println("Data"+ checkIn + checkOut + adults);
	  format.applyPattern("dd.MM.yyyy HH.mm.ss");
	  System.out.println("Data"+ checkIn + checkOut + adults);
	  
	} catch (ParseException e) {
	  System.out.println("Exception");
	  e.printStackTrace();
	}

	try {
	  if (areFieldsFilled()) {
		createRequest();
		page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.MAIN_PAGE_PATH);
		request.setAttribute(Parameters.OPERATION_MESSAGE,
		MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
	  } else {
		request.setAttribute(Parameters.OPERATION_MESSAGE,
		MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
		page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
	  }
	} catch (Exception e) {
	  System.out.println("Error");
	}

	return page;
  }

  private boolean areFieldsFilled() {
	boolean isFilled = false;
	if (checkIn != null && checkOut != null && adults != 0) {
	  isFilled = true;
	}
	return isFilled;
  }

  private void createRequest() throws SQLException {

	Request userRequest = new Request();

	userRequest.setCheckIn(checkIn);
	userRequest.setCheckOut(checkOut);
	userRequest.setAdults(adults);
	userRequest.setUser(user);

	System.out.println("request" + userRequest);
	RequestDAO.INSTANCE.createEntity(userRequest);
  }

}

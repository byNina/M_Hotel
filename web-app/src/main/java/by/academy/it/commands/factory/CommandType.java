package by.academy.it.commands.factory;


import by.academy.it.commands.Command;
import by.academy.it.commands.admin.ShowRequests;
import by.academy.it.commands.guest.*;
import by.academy.it.commands.user.CreateNewRequest;
import by.academy.it.commands.user.GoToRequestCreationCommand;
import by.academy.it.commands.user.ShowMyRequests;
import by.academy.it.commands.language.SetLanguageCommand;
import by.academy.it.tests.Test;


public enum CommandType {
  // test
  TEST,
  //common
  LANG, HOTELINFO, SHOWALLROOMS,
  
  // user commands
  GOTOREGISTRATION, REGISTRATION, LOGIN, LOGOUT, BACK, USERINFO, SHOWMYREQUESTS, CREATENEWREQUEST, GOTONEWREQUESTCREATION,
  
  //admin commands
  SHOWREQUESTS;

  public Command getCurrentCommand() throws EnumConstantNotPresentException {
	switch (this) {
	case TEST:
	  return new Test();
	case GOTOREGISTRATION:
	  return new GoToRegistrationCommand();
	case REGISTRATION:
	  return new UserRegistrationCommand();
	case LOGIN:
	  return new UserLoginCommand();
	case LOGOUT:
	  return new UserLogoutCommand();
	case BACK:
	  return new GoBackCommand();
	case USERINFO:
	  return new ShowUserInfoCommand();
	case SHOWMYREQUESTS:
	  return new ShowMyRequests();
	case SHOWREQUESTS:
	  return new ShowRequests();
	case GOTONEWREQUESTCREATION:
	  return new GoToRequestCreationCommand();
	case CREATENEWREQUEST:
	  return new CreateNewRequest();
	case LANG:
	  return new SetLanguageCommand();
	case HOTELINFO:
	  return new ShowHotelInfo();
	case SHOWALLROOMS:
	  return new ShowAllRooms();
	default:
	  throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
	}
  }
}
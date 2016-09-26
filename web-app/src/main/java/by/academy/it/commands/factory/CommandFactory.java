package by.academy.it.commands.factory;

import by.academy.it.commands.Command;
import by.academy.it.constants.Parameters;

import javax.servlet.http.HttpServletRequest;


/**
 * @author shevchenko
 * @version 1.0
 *
 */

public enum CommandFactory {
  INSTANCE;
	
	public Command defineCommand(HttpServletRequest request){
		Command current = null;
		String commandName = request.getParameter(Parameters.COMMAND);
		try{
			CommandType type = CommandType.valueOf(commandName.toUpperCase());
			current = type.getCurrentCommand();
		}
		catch(NullPointerException e){
			System.out.println(e);
		}
		catch(IllegalArgumentException e){
			System.out.println(e);
		}
		return current;
	}
}
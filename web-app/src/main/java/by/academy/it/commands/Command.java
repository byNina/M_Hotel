package by.academy.it.commands;

import javax.servlet.http.HttpServletRequest;
/**
 * @author shevchenko
 * @version 1.0
 *
 */
public interface Command {
  String execute(HttpServletRequest request);
}

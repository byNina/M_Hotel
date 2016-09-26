package by.academy.it.managers;

import by.academy.it.constants.ConfigsConstants;

import java.util.ResourceBundle;





/**
 * @author shevchenko
 * @version 1.0
 *
 */

public enum ConfigurationManager implements Manager{
  INSTANCE;
  
  private final ResourceBundle bundle = ResourceBundle.getBundle(ConfigsConstants.CONFIGS_SOURCE);

  @Override
  public String getProperty(String key) {
	return bundle.getString(key);
  }

}

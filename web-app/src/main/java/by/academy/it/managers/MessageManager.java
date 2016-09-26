/**
 * 
 */
package by.academy.it.managers;

import by.academy.it.constants.ConfigsConstants;

import java.util.ResourceBundle;



/**
 * @author shevchenko
 *
 */
public enum MessageManager implements Manager{
	INSTANCE;
	
	private final ResourceBundle bundle = ResourceBundle.getBundle(ConfigsConstants.MESSAGES_SOURCE);

	@Override
	public String getProperty(String key) {
		return bundle.getString(key);
	}
	
	
}


package by.academy.it.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import by.academy.it.constants.ConfigsConstants;
import org.apache.log4j.Logger;



/**
 * @author shevchenko
 *
 */
public enum ConnectionPool {
  INSTANCE;
  public Logger LOG = Logger.getLogger(ConnectionPool.class.getName());
  private DataSource dataSource;
  private Connection connection;

  {

	try {
	  InitialContext initContext = new InitialContext();
	  dataSource = (DataSource) initContext.lookup(ConfigsConstants.DATABASE_SOURCE);
	  LOG.info("Get connection");
	} catch (NamingException e) {
	  LOG.error("Connection exception:" + e);
	  System.out.println(e);
	}
  }

  public Connection getConnection() throws SQLException {
	connection = dataSource.getConnection();
	return connection;
  }

  public void releaseConnection(Connection connection) {
	if (connection != null) {
	  try {
		connection.close();
	  } catch (SQLException e) {
		// TODO ExceptionLogger
		System.out.println(e);
	  }
	}
  }
}

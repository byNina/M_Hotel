/**
 * 
 */
package by.academy.it.dao;

import by.academy.it.beans.User;
import by.academy.it.constants.ColumnNames;
import by.academy.it.constants.SqlRequests;
import by.academy.it.connectionpool.ConnectionPool;
import by.academy.it.constants.AccessLevel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * @author shevchenko
 *
 */

public enum UserDAO implements AbstractDAO<User> {
  INSTANCE;

//  public User getUserById(String id) throws SQLException {
//	User user = null;
//
//	Connection connection = ConnectionPool.INSTANCE.getConnection();
//	String query = SqlRequests.GET_USER_BY_ID;
//	PreparedStatement ps = connection.prepareStatement(query);
//	ps.setString(1, id);
//	ResultSet result = ps.executeQuery();
//	user = new User();
//	while (result.next()) {
//	  user.setLogin(result.getString("login"));
//	  user.setUserInfo(result.getString("contact_data"));
//	}
//	return user;
//
//  }

  /*
   * (non-Javadoc)
   * 
   * @see by.pvt.shevchenko.dao.AbstractDAO#findAll()
   */
  @Override
  public List<User> findAll() throws SQLException {
	// TODO Auto-generated method stub
	return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * by.pvt.shevchenko.dao.AbstractDAO#createEntity(by.pvt.shevchenko.beans.
   * Entity)
   */
  @Override
  public void createEntity(User user) throws SQLException {
	Connection connection = ConnectionPool.INSTANCE.getConnection();
	PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_USER);
	statement.setString(1, user.getLogin());
	statement.setString(2, user.getPassword());
	statement.setString(3, user.getUserInfo());
	statement.setInt(4, user.getAccountType());
	statement.executeUpdate();
	ConnectionPool.INSTANCE.releaseConnection(connection);
  }

  /*
   * (non-Javadoc)
   * 
   * @see by.pvt.shevchenko.dao.AbstractDAO#getEntityById(int)
   */
  @Override
  public User getEntityById(int id) throws SQLException {
	// TODO Auto-generated method stub
	return null;
  }

//  public boolean isAuthorized(String login, String password) throws SQLException {
//	boolean isLogIn = false;
//	Connection connection = ConnectionPool.INSTANCE.getConnection();
//	PreparedStatement statement = connection.prepareStatement(SqlRequests.CHECK_AUTHORIZATION);
//	statement.setString(1, login);
//	statement.setString(2, password);
//	ResultSet result = statement.executeQuery();
//	if (result.next()) {
//	  isLogIn = true;
//	}
//	ConnectionPool.INSTANCE.releaseConnection(connection);
//	return isLogIn;
//  }

  /**
   * @param login
   * @return
   */
  public User getUserByLogin(String login) throws SQLException {
	User user = null;
	Connection connection = ConnectionPool.INSTANCE.getConnection();
	PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_USER_BY_LOGIN);
	statement.setString(1, login);
	ResultSet result = statement.executeQuery();
	while (result.next()) {
	  user = new User();
	  user.setId(result.getInt(ColumnNames.USER_ID));
	  user.setLogin(result.getString(ColumnNames.USER_LOGIN));
	  user.setPassword(result.getString(ColumnNames.USER_PASSWORD));
	  user.setUserInfo(result.getString(ColumnNames.USER_CONTACT_DATA));
	  user.setAccountType(result.getInt(ColumnNames.USER_ACCESS_LEVEL));
	}
	ConnectionPool.INSTANCE.releaseConnection(connection);
	return user;
  }

//  public AccessLevel checkAccessLevel(String login) throws SQLException {
//	AccessLevel accessLvl = null;
//	Connection connection = ConnectionPool.INSTANCE.getConnection();
//	PreparedStatement statement = connection.prepareStatement(SqlRequests.CHECK_ACCESS_LEVEL);
//	statement.setString(1, login);
//	ResultSet result = statement.executeQuery();
//	while (result.next()) {
//	  if (AccessLevel.USER.accessLevel() == result.getInt(ColumnNames.USER_ACCESS_LEVEL)) {
//		accessLvl = AccessLevel.USER;
//	  } else {
//		accessLvl = AccessLevel.ADMIN;
//	  }
//	}
//	ConnectionPool.INSTANCE.releaseConnection(connection);
//	return accessLvl;
//  }

}

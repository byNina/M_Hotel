/**
 * 
 */
package by.academy.it.constants;

/**
 * @author shevchenko
 *
 */
public class SqlRequests {
  
//  public static final String GET_USER_BY_ID = "SELECT * FROM users";
  public static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
  public static final String CHECK_AUTHORIZATION = "SELECT login, password FROM users WHERE login = ? AND password = ?";
  public static final String GET_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
  public static final String CHECK_ACCESS_LEVEL = "SELECT account_type FROM users WHERE login = ?";
  public static final String ADD_USER = "INSERT INTO users(login, password, contact_data, account_type) VALUES (?, ?, ?, ?)";
  public static final String GET_APARTMENT_TYPES = "SELECT * FROM apartment_type";
  public static final String GET_ALL_REQUESTS = "SELECT * FROM requests JOIN users ON requests.user_id=users.id LEFT JOIN  invoices ON requests.invoice_id=invoices.id";
  public static final String GET_REQUESTS_BY_USER = "SELECT * FROM requests WHERE user_id = ? ";
  public static final String ADD_REQUEST = "INSERT INTO requests(check_in, check_out, adults, user_id) VALUES (?, ?, ?, ?)";;

}

/**
 *
 */
package by.academy.it.dao;

import by.academy.it.beans.User;
import by.academy.it.beans.Invoice;
import by.academy.it.beans.Request;
import by.academy.it.connectionpool.ConnectionPool;
import by.academy.it.constants.SqlRequests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author shevchenko
 */
public enum RequestDAO implements AbstractDAO<Request> {
    INSTANCE;

    @Override
    public List<Request> findAll() throws SQLException {
        System.out.println("1");
        Request request = null;
        User user = null;
        Invoice invoice = null;
        List<Request> requests = null;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        String query = SqlRequests.GET_ALL_REQUESTS;
        System.out.println("2");
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet result = ps.executeQuery();
        requests = new ArrayList<Request>();
        System.out.println("3");
        while (result.next()) {
            request = new Request();
            request.setId(result.getInt("id"));
            request.setCheckIn(result.getDate("check_in"));
            request.setCheckOut(result.getDate("check_out"));
            request.setAdults(result.getInt("adults"));
            user = new User();
            user.setId(result.getInt("user_id"));
            user.setLogin(result.getString("login"));
            user.setUserInfo("contact_data");
            request.setUser(user);
            invoice = new Invoice();
            invoice.setId(result.getInt("invoice_id"));
            System.out.println("Before total");
            invoice.setTotalPrice(result.getInt("total_price"));
            System.out.println("After total");
            invoice.setPaid(result.getBoolean("paid"));

            request.setInvoice(invoice);
            requests.add(request);
        }
        return requests;
    }

    @Override
    public void createEntity(Request userRequest) throws SQLException {
        System.out.println("In create");

        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_REQUEST);
        java.sql.Date sqlCheckIn = new java.sql.Date(userRequest.getCheckIn().getTime());
        java.sql.Date sqlCheckOut = new java.sql.Date(userRequest.getCheckOut().getTime());
        statement.setDate(1, sqlCheckIn);
        statement.setDate(2, sqlCheckOut);
        statement.setInt(3, userRequest.getAdults());
        statement.setInt(4, userRequest.getUser().getId());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    @Override
    public Request getEntityById(int id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Request> findRequestByUser(User user) throws SQLException {
        Request request = null;
        int userId = user.getId();
        List<Request> requests = null;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        String query = SqlRequests.GET_REQUESTS_BY_USER;
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, userId);
        ResultSet result = ps.executeQuery();
        requests = new ArrayList<Request>();
        while (result.next()) {
            request = new Request();
            request.setId(result.getInt("id"));
            request.setCheckIn(result.getDate("check_in"));
            request.setCheckOut(result.getDate("check_out"));
            request.setAdults(result.getInt("adults"));
            requests.add(request);
            System.out.println("Get result" + request);
        }
        return requests;
    }

    /**
     * @param request
     */

}

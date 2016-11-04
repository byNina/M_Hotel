package by.academy.it.dao.daoimplementation;

import by.academy.it.beans.User;
import by.academy.it.dao.IUserDAO;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 24.09.2016.
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements IUserDAO<User> {
    private static final String GET_ALL_USERS = "FROM User u";
    private static final String GET_USER_BY_LOGIN_AND_PASS = "FROM User u WHERE u.login=:userLogin AND u.password=:userPassword ";
    private static final String GET_USER_BY_LOGIN = "FROM User u WHERE u.login=:userLogin";

    @Override
    public List<User> getAllUsers() {
        Query query = getSession().createQuery(GET_ALL_USERS);
        List<User> results = query.list();
        return results;
    }

    @Override
    public User getUserById(Integer userId) {

        return null;
    }

    @Override
    public User getUser(String login, String password) {
        User user;
        Query query = getSession().createQuery(GET_USER_BY_LOGIN_AND_PASS);
        query.setParameter("userLogin", login);
        query.setParameter("userPassword", password);
        user = (User) query.uniqueResult();
        return user;
    }

    @Override
    public User getUser(String login) {
        User user;
        Query query = getSession().createQuery(GET_USER_BY_LOGIN);
        query.setParameter("userLogin", login);
        user = (User) query.uniqueResult();
        return user;
    }


}

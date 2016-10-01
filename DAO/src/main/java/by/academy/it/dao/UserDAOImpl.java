package by.academy.it.dao;

import by.academy.it.beans.User;
import by.academy.it.constants.AccessLevel;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 24.09.2016.
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements IUserDAO<User> {

    @Override
    public List<User> getAllUsers() {
        String hql = "FROM User u";
        Query query = getSession().createQuery(hql);
        List<User> results = query.list();
        return results;
    }

    @Override
    public User getUserById(Integer userId) {

        return null;
    }

    @Override
    public User getUser(String login, String password) {
        User user = null;
        String hql = "FROM User u WHERE u.login=:userLogin AND u.password=:userPassword ";
        Query query = getSession().createQuery(hql);
        query.setParameter("userLogin", login);
        query.setParameter("userPassword", password);
        user = (User) query.uniqueResult();
        return user;
    }

    @Override
    public User getUser(String login) {
        User user = null;
        String hql = "FROM User u WHERE u.login=:userLogin";
        Query query = getSession().createQuery(hql);
        query.setParameter("userLogin", login);
        user = (User) query.uniqueResult();
        return user;
    }




}

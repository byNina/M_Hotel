package by.academy.it.dao;

import by.academy.it.beans.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 24.09.2016.
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements IUserDAO<User> {


    public List<User> getAllUsers() {
        String hql = "FROM User u";
        Query query = getSession().createQuery(hql);
        List<User> results = query.list();
        return results;
    }


}

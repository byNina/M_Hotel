package by.academy.it;

import by.academy.it.beans.User;
import by.academy.it.dao.IUserDAO;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 24.09.2016.
 */
@Service
@Transactional
public class UserService implements IUserService{
    private static Logger log = Logger.getLogger(UserService.class);

    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<User> getAllUsers() {
        List<User> users = null;
        try {
            users = userDAO.getAllUsers();
        } catch (HibernateException e) {
            log.error("Error getting users" + e);
        }
               return users;

    }
}

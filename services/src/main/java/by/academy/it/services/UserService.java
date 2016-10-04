package by.academy.it.services;

import by.academy.it.beans.User;
import by.academy.it.dao.IUserDAO;
import by.academy.it.exceptions.DaoException;
import by.academy.it.exceptions.ServiceException;
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
public class UserService implements IUserService<User> {
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

    @Override
    public User getUserById(Integer userId) {
        User user = null;
        try {
            user = (User) userDAO.get(userId);
        } catch (HibernateException e) {
            log.error("Error getting user by Id" + e);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean isAuthorized(String login, String password) {
        boolean isLogIn = false;
        try {
            User user = userDAO.getUser(login, password);
            if (user != null) {
                isLogIn = true;
            }
        } catch (HibernateException e) {
            System.out.println("isAuthorized Error");
            log.error("Error getting user by Login & Password" + e);
        }
        return isLogIn;
    }

    @Override
    public User getUser(String login) {
        User user = null;
        try {
            user = userDAO.getUser(login);
        } catch (HibernateException e) {
            log.error("Error getting user by Login & Password" + e);
        }
        return user;
    }

    public void save(User user) {
        try {
            userDAO.saveOrUpdate(user);
        } catch (HibernateException e) {
            log.error("Error during saving Entity" + e);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }


}
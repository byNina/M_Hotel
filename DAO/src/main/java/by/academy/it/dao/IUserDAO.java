package by.academy.it.dao;

import by.academy.it.beans.User;
import by.academy.it.constants.AccessLevel;

import java.util.List;

/**
 * Created by User on 24.09.2016.
 */
public interface IUserDAO<T> extends IDAO<T> {

    List<User> getAllUsers();

    User getUserById (Integer userId);

    User getUser(String login,String password);

    User getUser(String login);


}

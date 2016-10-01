package by.academy.it;

import by.academy.it.beans.User;
import by.academy.it.constants.AccessLevel;

import java.util.List;

/**
 * Created by User on 24.09.2016.
 */
public interface IUserService {

    List<User> getAllUsers();

    User getUserById(Integer userId);

    boolean isAuthorized(String login, String password);

    User getUser(String login);


}

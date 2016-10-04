package by.academy.it.services;

import by.academy.it.beans.User;
import by.academy.it.constants.AccessLevel;

import java.util.List;

/**
 * Created by User on 24.09.2016.
 */
public interface IUserService<T> {

    List<T> getAllUsers();

    T getUserById(Integer userId);

    boolean isAuthorized(String login, String password);

    T getUser(String login);

    void save (T t);



}

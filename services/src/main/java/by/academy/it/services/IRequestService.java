package by.academy.it.services;

import by.academy.it.beans.User;

import java.util.List;

/**
 * Created by User on 02.10.2016.
 */
public interface IRequestService<T> {

    List<T> getAllRequests();

    List<T> getAllRequests(Integer page, Integer pageSize);

    int getTotalCount();

    List<T> getUserRequests(User user, int page, int pagesize);

}

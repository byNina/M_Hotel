package by.academy.it.dao;

import java.util.List;

/**
 * Created by User on 23.09.2016.
 */
public interface IRequestDAO<T> extends IDAO<T> {

    List<T> getAllRequests() ;

    List<T> getAllRequests(Integer page, Integer pageSize) ;

    List<T> getUserRequests(Integer id, Integer page, Integer pageSize) ;
}

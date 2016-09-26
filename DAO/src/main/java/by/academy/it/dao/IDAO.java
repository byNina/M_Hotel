package by.academy.it.dao;

import by.academy.it.exceptions.DaoException;

import java.io.Serializable;

/**
 * Created by User on 23.09.2016.
 */
public interface IDAO<T> {

    void saveOrUpdate(T t) throws DaoException;

    T get(Serializable id) throws DaoException;

    T load(Serializable id) throws DaoException;

    void delete(T t) throws DaoException;

    Serializable save(T entity) throws DaoException;
}

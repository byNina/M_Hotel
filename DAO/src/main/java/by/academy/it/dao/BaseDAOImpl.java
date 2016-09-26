package by.academy.it.dao;

import by.academy.it.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by User on 23.09.2016.
 */
public class BaseDAOImpl<T> implements IDAO<T> {

    protected Logger log = Logger.getLogger(getClass());
    @Autowired
    protected SessionFactory sessionFactory;

    public BaseDAOImpl() {
    }

    @Override
    public void saveOrUpdate(T t) throws DaoException {
        log.info("SaveOrUpdate entity: " + t.getClass().getName());
        try {
            getSession().saveOrUpdate(t);
            log.info("Saved or updated entity: " + t);
        } catch (HibernateException e) {
            log.error("Error saving or updating entity of " + t.getClass().getName() + " class.");
            throw new DaoException(e);
        }
    }

    @Override
    public T get(Serializable id) throws DaoException {
        return null;
    }

    @Override
    public T load(Serializable id) throws DaoException {
        return null;
    }

    @Override
    public void delete(T t) throws DaoException {

    }

    @Override
    public Serializable save(T entity) throws DaoException {
        return null;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}

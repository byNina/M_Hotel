package by.academy.it.dao.DAOImplementation;

import by.academy.it.beans.Request;
import by.academy.it.dao.DAOImplementation.BaseDAOImpl;
import by.academy.it.dao.IRequestDAO;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 23.09.2016.
 */

@Repository
public class RequestDAOImpl extends BaseDAOImpl<Request> implements IRequestDAO<Request> {
    private static final String GET_ALL_REQUESTS = "FROM Request R";
    private static final String GET_USER_REQUEST = "FROM Request R WHERE R.user.id=:userId";

    @Override
    public List<Request> getAllRequests() {
        Query query = getSession().createQuery(GET_ALL_REQUESTS);
        List<Request> results = query.list();
        return results;
    }

    @Override
    public List<Request> getAllRequests(Integer page, Integer pageSize) {
        int fistResult = (page - 1) * pageSize;
        int maxResult = page * pageSize;
        Query query = getSession().createQuery(GET_ALL_REQUESTS);
        query.setFirstResult(fistResult);
        query.setMaxResults(maxResult);
        List<Request> results = query.list();
        return results;
    }

    @Override
    public List<Request> getUserRequests(Integer id, Integer page, Integer pageSize) {
        int fistResult = (page - 1) * pageSize;
        int maxResult = page * pageSize;
        Query query = getSession().createQuery(GET_USER_REQUEST);
        query.setParameter("userId", id);
        query.setFirstResult(fistResult);
        query.setMaxResults(maxResult);
        List<Request> results = query.list();
        return results;
    }


}

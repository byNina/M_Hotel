package by.academy.it.dao;

import by.academy.it.beans.Request;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 23.09.2016.
 */

@Repository
public class RequestDAOImpl extends BaseDAOImpl<Request> implements IRequestDAO<Request> {

    @Override
    public List<Request> getAllRequests() {
        String hql = "FROM Request R";
        Query query = getSession().createQuery(hql);
        List<Request> results = query.list();
        return results;
    }

    @Override
    public List<Request> getAllRequests(Integer page, Integer pageSize) {
        int fistResult = (page-1)*pageSize;
        int maxResult = page*pageSize;
        String hql = "FROM Request R";
        Query query = getSession().createQuery(hql);
        query.setFirstResult(fistResult);
        query.setMaxResults(maxResult);
        List<Request> results = query.list();
        return results;
    }

    @Override
    public List<Request> getUserRequests(Integer id, Integer page, Integer pageSize) {
        int fistResult = (page-1)*pageSize;
        int maxResult = page*pageSize;
        String hql = "FROM Request R WHERE R.user.id=:userId";
        Query query = getSession().createQuery(hql);
        query.setParameter("userId", id);
        query.setFirstResult(fistResult);
        query.setMaxResults(maxResult);
        List<Request> results = query.list();
        return results;
    }


}

package by.academy.it.services;

import by.academy.it.beans.Request;
import by.academy.it.beans.User;
import by.academy.it.dao.IRequestDAO;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 02.10.2016.
 */
@Service
@Transactional
public class RequestService implements IRequestService<Request> {
    private static Logger log = Logger.getLogger(UserService.class);

    @Autowired
    private IRequestDAO requestDAO;

    @Override
    public List<Request> getAllRequests() {
        List<Request> requests = null;
        try {
            requests = requestDAO.getAllRequests();
        } catch (HibernateException e) {
            log.error("Error getting users" + e);
        }
        return requests;

    }

    @Override
    public List<Request> getAllRequests(Integer page, Integer pageSize) {
        List<Request> requests = null;
        try {
            requests = requestDAO.getAllRequests(page, pageSize);
        } catch (HibernateException e) {
            log.error("Error getting users" + e);
        }
        return requests;
    }



    @Override
    public int getTotalCount() {
        int totalCount = 0;
        List<Request> requests = null;
        try {
            requests = requestDAO.getAllRequests();
        } catch (HibernateException e) {
            log.error("Error getting users" + e);
        }
        totalCount = requests.size();
        return totalCount;
    }

    @Override
    public List<Request> getUserRequests(User user, int page, int pageSize) {
        List<Request> requests = null;
        int id = user.getId();
        try {
            requests = requestDAO.getUserRequests(id, page, pageSize);
        } catch (HibernateException e) {
            log.error("Error getting users" + e);
        }
        return requests;

    }
}

package by.academy.it.dao;

import by.academy.it.beans.ApartmentType;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 07.10.2016.
 */
@Repository
public class ApartmentTypeDAOImpl extends BaseDAOImpl<ApartmentType> implements IApartmentTypeDAO<ApartmentType> {

    @Override
    public List<ApartmentType> getAllApartments() {
        String hql = "FROM ApartmentType";
        Query query = getSession().createQuery(hql);
        List<ApartmentType> results = query.list();
        return results;
    }
}

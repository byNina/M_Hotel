package by.academy.it.dao.daoimplementation;

import by.academy.it.beans.ApartmentType;
import by.academy.it.dao.IApartmentTypeDAO;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 07.10.2016.
 */
@Repository
public class ApartmentTypeDAOImpl extends BaseDAOImpl<ApartmentType> implements IApartmentTypeDAO<ApartmentType> {
    private static final String GET_ALL_APARTMENT_TYPES = "FROM ApartmentType";

    @Override
    public List<ApartmentType> getAllApartments() {
        Query query = getSession().createQuery(GET_ALL_APARTMENT_TYPES);
        List<ApartmentType> results = query.list();
        return results;
    }
}

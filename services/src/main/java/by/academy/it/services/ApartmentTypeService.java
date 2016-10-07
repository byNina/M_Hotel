package by.academy.it.services;

import by.academy.it.beans.ApartmentType;
import by.academy.it.dao.IApartmentTypeDAO;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by User on 07.10.2016.
 */
@Service
@Transactional
public class ApartmentTypeService implements IApartmentTypeService<ApartmentType> {
    private static Logger log = Logger.getLogger(UserService.class);

    @Autowired
    private IApartmentTypeDAO apartmentTypeDAO;

    @Override
    public List<ApartmentType> getAllApartments() {
        List<ApartmentType> apartments = null;
        try {
            System.out.println("before dao" );
            apartments = apartmentTypeDAO.getAllApartments();
            System.out.println("after dao" + apartments);
        } catch (HibernateException e) {
            System.out.println("hibern error" + e);
            log.error("Error getting users" + e);
        }
        return apartments;
    }
}

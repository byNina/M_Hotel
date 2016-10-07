package by.academy.it.dao;

import by.academy.it.beans.ApartmentType;

import java.util.List;

/**
 * Created by User on 07.10.2016.
 */
public interface IApartmentTypeDAO<T> extends IDAO<T>  {

    List<ApartmentType> getAllApartments();
}

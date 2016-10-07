package by.academy.it.services;

import by.academy.it.beans.ApartmentType;

import java.util.List;

/**
 * Created by User on 07.10.2016.
 */
public interface IApartmentTypeService<T> {

    List<T> getAllApartments ();
}

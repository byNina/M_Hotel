package by.academy.it.dao;

import by.academy.it.beans.Entity;

import java.sql.SQLException;
import java.util.List;



public interface AbstractDAO<T extends Entity> {

  List<T> findAll() throws SQLException;

  public void createEntity(T entity) throws SQLException;

  public T getEntityById(int id) throws SQLException;

}

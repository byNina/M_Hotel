/**
 * 
 */
package by.academy.it.dao;

import by.academy.it.beans.ApartmentType;
import by.academy.it.constants.SqlRequests;
import by.academy.it.connectionpool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




/**
 * @author shevchenko
 *
 */
public enum ApartmentTypeDAO implements AbstractDAO<ApartmentType> {
  INSTANCE;

  @Override
  public List<ApartmentType> findAll() throws SQLException {
	ApartmentType apartmentType = null;
	List<ApartmentType> apartmentTypes = null;
	Connection connection = ConnectionPool.INSTANCE.getConnection();
	String query = SqlRequests.GET_APARTMENT_TYPES;
	PreparedStatement ps = connection.prepareStatement(query);
	ResultSet result = ps.executeQuery();
	apartmentTypes = new ArrayList<ApartmentType>();
	while (result.next()) {
	  apartmentType = new ApartmentType();
	  apartmentType.setId(result.getInt("id"));
	  apartmentType.setType(result.getString("type"));
	  apartmentType.setPricePerNight(result.getInt("price_per_night"));
	  apartmentType.setMaxGuests(result.getInt("max_guests"));
	  apartmentTypes.add(apartmentType);
	}
		return apartmentTypes;
  }

  @Override
  public void createEntity(ApartmentType entity) throws SQLException {
	// TODO Auto-generated method stub

  }

  @Override
  public ApartmentType getEntityById(int id) throws SQLException {
	// TODO Auto-generated method stub
	return null;
  }

}

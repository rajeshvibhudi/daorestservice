/**
 * 
 */
package com.daorest.dao;

import java.io.Serializable;
import java.util.List;

import com.daorest.beans.Location;;

/**
 * @author Rajesh Vibhudi
 *
 */
public interface LocationDao extends Serializable {

	public void addLocation(Location location);

	public void deleteLocation(Location location);

	public void updateLocation(Location location);

	public List<Location> listAllLocations(Class clazz);
	
	public Location getLocationById(Class clazz, int id); 

}

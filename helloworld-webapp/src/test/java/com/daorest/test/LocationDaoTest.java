/**
 * 
 */
package com.daorest.test;

import java.util.List;

import com.daorest.beans.Location;
import com.daorest.dao.LocationDao;
import com.daorest.daoImpl.LocationDaoImpl;

/**
 * @author Rajesh Vibhudi
 *
 */
public class LocationDaoTest {
	/*public void saveLocation(Location location){
		HibernateUtil.beginTransaction();
		LocationDao locationDao = new LocationDaoImpl();
		locationDao.addLocation(location);
		HibernateUtil.commitTransaction();
	}*/
	/*public Location getLocationById(int locationId){
		HibernateUtil.beginTransaction();
		LocationDao  locationDao = new LocationDaoImpl();
		Location location= locationDao.getLocationById(Location.class, locationId);
		HibernateUtil.commitTransaction();
		return location;
	}*/

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Location location=new Location();
		location.setCity("Guntur");
		location.setState("AndraPradesh2");
		//employee.setLocation("hyd");
		location.setStreet("LowerTank2");
		location.setZipcode("5000080");
		System.out.println(location.toString());
		LocationDaoTest daoTest = new LocationDaoTest();
		daoTest.saveLocation(location);
		LocationDao locationDao = new LocationDaoImpl();
		//locationDao.addLocation(location);
		Location location1 = locationDao.getLocationById(Location.class, 4);
		//System.out.println(location1);
		location1.setZipcode("560512");
		locationDao.updateLocation(location1);
		//System.out.println(location1);
		Location location2 = locationDao.getLocationById(Location.class, 4);
		System.out.println(location2);
*/	
		LocationDaoTest daoTest = new LocationDaoTest();
		LocationDao locationDao = new LocationDaoImpl();
		/*List<Location> locations = locationDao.listAllLocations(Location.class);
		for (Location location : locations) {
			System.out.println(locatioon.toString());
		}*/
		Location location2 = locationDao.getLocationById(Location.class, 4);
		locationDao.deleteLocation(location2);
		}

}

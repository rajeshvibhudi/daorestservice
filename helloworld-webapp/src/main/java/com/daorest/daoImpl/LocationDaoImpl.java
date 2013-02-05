package com.daorest.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.daorest.beans.Employee;
import com.daorest.beans.Location;
import com.daorest.dao.LocationDao;
import com.daorest.utils.HibernateUtil;
/*
 * Author Rajesh Vibhudi
 */
public class LocationDaoImpl implements LocationDao {
	private static final long serialVersionUID = 1L;
	protected Session getSession() {
		return HibernateUtil.getSession();
	}
	Session hibernateSession = this.getSession();
	public void addLocation(Location location) {
		// TODO Auto-generated method stub
		
		hibernateSession.saveOrUpdate(location);

	}

	public void deleteLocation(Location location) {
		// TODO Auto-generated method stub
	///	Session hibernateSession = this.getSession();
		hibernateSession.beginTransaction();
		hibernateSession.delete(location);
		hibernateSession.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	public List<Location> listAllLocations(Class clazz) {
		// TODO Auto-generated method stub
		System.out.println(clazz);
		hibernateSession.beginTransaction();
		List<Location> loactionList = null;
		Query query = hibernateSession.createQuery("from " + clazz.getName());
		loactionList = query.list();
		hibernateSession.getTransaction().commit();
		return loactionList;
	}

	public void updateLocation(Location location) {
		// TODO Auto-generated method stub
		//Session hibernateSession = this.getSession();
		hibernateSession.beginTransaction();
		hibernateSession.merge(location);
		hibernateSession.getTransaction().commit();
	}

	public Location getLocationById(Class clazz, int id) {
		// TODO Auto-generated method stub
//		Session hibernateSession = this.getSession();
		Location location = null;
		location = (Location) hibernateSession.get(clazz, id);
		return location;
	}
	

}

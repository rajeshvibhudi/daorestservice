package com.daorest.test;

import org.hibernate.Session;

import com.daorest.utils.HibernateUtil;

public class HibernateClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HibernateUtil hbu=new HibernateUtil();
		System.out.println(hbu);
		Session ss=hbu.getSession();
		System.out.println(ss);
	}

}

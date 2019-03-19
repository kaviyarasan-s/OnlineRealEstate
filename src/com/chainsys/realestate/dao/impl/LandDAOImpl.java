package com.chainsys.realestate.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.chainsys.realestate.dao.LandDAO;
import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.util.HibernateConnectionUtil;

public class LandDAOImpl implements LandDAO {

	@Override
	public boolean addLand(Land land) {
		boolean success = false;
		// Create session factory object
		SessionFactory sessionFactory = HibernateConnectionUtil
				.getSessionFactory();
		// getting session object from session factory
		Session session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();

		int result =  (int) session.save(land);

		if (result > 0) {
			success = true;
		}

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		return success;

		
	}

}

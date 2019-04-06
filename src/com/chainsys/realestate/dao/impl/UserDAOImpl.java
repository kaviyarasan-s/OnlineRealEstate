package com.chainsys.realestate.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.chainsys.realestate.dao.UserDAO;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.util.HibernateConnectionUtil;

public class UserDAOImpl implements UserDAO {
	static SessionFactory sessionFactory;
	static Session session;

	public UserDAOImpl() {
		// Create session factory object
		sessionFactory = HibernateConnectionUtil.getSessionFactory();
	}

	@Override
	public boolean addUserDetails(Users user) {
		boolean success = false;
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object.
		session.beginTransaction();
		try {
			long result = (long) session.save(user);
			if (result > 0) {
				success = true;
			}
			commitTransaction();
		} catch (Exception e) {
			success=false;
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		return success;
	}

	@Override
	public Users getUserDetailsById(Users user) {
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object.
		session.beginTransaction();
		Users userDetails = null;
		try {
			Query<Users> query = session.createQuery(
					"from Users where user_id=:id ", Users.class);
			query.setParameter("id", user.getId());
			List<Users> userList = query.list();
			if (!userList.isEmpty() && userList != null) {
				userDetails = userList.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userDetails;
	}

	@Override
	public boolean changePassword(Users user) {
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object.
		session.beginTransaction();
		boolean success = true;
		try {
			session.saveOrUpdate(user);
			commitTransaction();
		} catch (HibernateException e) {
			success=false;
			e.printStackTrace();
		} finally {
			session.close();
		}
		return success;
	}

	@Override
	public Users getUserDetailsByEmail(Users user) {
		Users userDetails = null;
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object.
		session.beginTransaction();
		try {
			Query<Users> query = session.createQuery(
					"from Users where email=:mail ", Users.class);
			query.setParameter("mail", user.getEmail());
			List<Users> userList = query.list();
			if (!userList.isEmpty() && userList != null) {
				userDetails = userList.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userDetails;
	}

	@Override
	public boolean editProfileInfo(Users user) {
		boolean success = true;
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object.
		session.beginTransaction();
		try {
			session.saveOrUpdate(user);
			commitTransaction();
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		} finally {
			session.close();
		}
		return success;
	}

	public void commitTransaction() {
		try {
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}

package com.chainsys.realestate.dao.impl;

import java.util.List;

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
		sessionFactory = HibernateConnectionUtil
				.getSessionFactory();
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object.
		session.beginTransaction();
	}

	@Override
	public boolean addUserDetails(Users user) {
		boolean success = false;

		long result = (long) session.save(user);

		if (result > 0) {
			success = true;
		}

		commitTransaction();		
		return success;
	}

	@Override
	public Users getUserDetailsById(Users user) {

		
		Query<Users> query = session.createQuery("from Users where user_id=:id ",
				Users.class);

		query.setParameter("id", user.getId());
		List<Users> userList = query.list();
		
		return userList.get(0);
	}

	@Override
	public boolean changePassword(Users user) {
		boolean success = true;	
		session.saveOrUpdate(user);
		commitTransaction();
		return success;
	}

	@Override
	public Users getUserDetailsByEmail(Users user) {
		
		Query<Users> query = session.createQuery("from Users where email=:mail ",
				Users.class);

		query.setParameter("mail", user.getEmail());
		List<Users> userList = query.list();
		Users userDetails = null;
		if (!userList.isEmpty() && !userList.equals(null)) {
			userDetails = userList.get(0);
		}
		
		return userDetails;
	}

	@Override
	public boolean editProfileInfo(Users user) {
		System.out.println(user);
		session.saveOrUpdate(user);
		commitTransaction();
		
		return true;
	}
	
	
	public void commitTransaction()
	{
		session.getTransaction().commit();
	}
}

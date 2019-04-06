package com.chainsys.realestate.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.chainsys.realestate.dao.LoginDAO;
import com.chainsys.realestate.model.Users;
import com.chainsys.realestate.util.HibernateConnectionUtil;

public class LoginDAOImpl implements LoginDAO {
	static SessionFactory sessionFactory;
	static Session session;

	public LoginDAOImpl() {
		// Create session factory object
		sessionFactory = HibernateConnectionUtil.getSessionFactory();
	}

	@Override
	public boolean checkLoginCredentials(Users users) {
		boolean success = false;
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object.
		session.beginTransaction();
		try {
			Query<Users> query = session.createQuery(
					"from Users where email=:email and password=:password ",
					Users.class);
			query.setParameter("email", users.getEmail());
			query.setParameter("password", users.getPassword());
			List<Users> userList = query.list();
			if (!userList.isEmpty() && userList != null) {
				success = true;
			}
		} catch (Exception e) {
			success=false;
			e.printStackTrace();
		} finally {
			session.close();
		}
		return success;
	}
}

package com.chainsys.realestate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.chainsys.realestate.dao.FilterDAO;
import com.chainsys.realestate.model.Land;
import com.chainsys.realestate.util.HibernateConnectionUtil;

public class FilterDAOImpl implements FilterDAO {
	static SessionFactory sessionFactory;
	static Session session;

	public FilterDAOImpl() {
		// Create session factory object
		sessionFactory = HibernateConnectionUtil.getSessionFactory();
		// getting session object from session factory
		session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Land> filerLandByBhkPriceTrnType(Land land) {

		Query<Land> query = session
				.createQuery("from Land where bhk=:bhk and price=:price and transactionType=:trntype");
		query.setParameter("bhk", land.getBhk());
		query.setParameter("price", land.getPrice());
		query.setParameter("trntype", land.getTransactionType());
		List<Land> landDetails = query.list();
		return landDetails;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Land> filerLandByBhkPrice(Land land) {
		
		Query<Land> query = session
				.createQuery("from Land where bhk=:bhk and price=:price");
		query.setParameter("bhk", land.getBhk());
		query.setParameter("price", land.getPrice());
		
		List<Land> landDetails = query.list();
		return landDetails;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Land> filerLandByBhkTrnType(Land land) {
		Query<Land> query = session
				.createQuery("from Land where bhk=:bhk and transactionType=:trntype");
		query.setParameter("bhk", land.getBhk());	
		query.setParameter("trntype", land.getTransactionType());
		List<Land> landDetails = query.list();
		return landDetails;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Land> filerLandByPriceTrnType(Land land) {
		Query<Land> query = session
				.createQuery("from Land where price=:price and transactionType=:trntype");
		
		query.setParameter("price", land.getPrice());
		query.setParameter("trntype", land.getTransactionType());
		List<Land> landDetails = query.list();
		return landDetails;
	}

	@Override
	public List<Land> getLandDetailsById(Land land) {
		// TODO Auto-generated method stub
		return null;
	}

}

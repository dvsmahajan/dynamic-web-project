package com.pritesh.userapp.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pritesh.userapp.model.UserEntity;

@Repository
public class UserRepository {

	@Autowired
	private SessionFactory factory;
	
	public UserEntity save(UserEntity entity) {
		Session session =null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			  session.save(entity);
			transaction.commit();
			return entity;
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			System.out.println("Exception occured while saving data.\nException is "+e);
			return null;
		}
		
	}

	public UserEntity getUserById(Integer userId) {
		Session session =null;
		try {
			session = factory.openSession();
			UserEntity entity = session.get(UserEntity.class, userId);
			return entity;
		}catch (Exception e) {
			System.out.println("Exception occured while saving data.\nException is "+e);
			return null;
		}
	}

}

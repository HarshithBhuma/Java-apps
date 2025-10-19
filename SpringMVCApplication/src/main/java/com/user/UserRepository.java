package com.user;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepository {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction tx;

	public void addUser(User user) {
		session = sessionFactory.openSession();
		session.save(user);
		tx = session.beginTransaction();
		tx.commit();
	}

	public List<User> getUser(String username, String password) {
		session = sessionFactory.openSession();
		Query q = session.createQuery("from User u where email=:username and password=:password");
		List<User> li = q.setParameter("username", username).setParameter("password", password).list();
		return li;
	}

}

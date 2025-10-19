package com.ex;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class SpringORM {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insert(Player pl) {
		Session se = sessionFactory.openSession();
		Transaction tx = se.beginTransaction();
		se.save(pl);
		tx.commit();
	}

	public void select() {
		Session se = sessionFactory.openSession();
		Query q = se.createQuery("from Player pl");

		List li = q.list();
		Iterator i = li.iterator();

		while (i.hasNext()) {
			Player p = (Player) i.next();
			System.out.println(p.getId() + " " + p.getPlayer_name() + " " + p.getAge() + " " + p.getRuns());
		}
	}

	public void delete(Player pl) {
		Session se = sessionFactory.openSession();
		Transaction tx = se.beginTransaction();
		se.delete(pl);
		tx.commit();
	}

}

package com.ex;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientRepository {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction tx;

	public void savePatient(Patient p) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(p);
		tx.commit();
	}

	public List<Patient> getPatient() {
		session = sessionFactory.openSession();

		Query q = session.createQuery("from Patient p");
		List<Patient> li = q.list();
		return li;
	}

	public Patient getPatient(int id) {
		session = sessionFactory.openSession();

		return session.get(Patient.class, id);
	}

	public void updatePatient(Patient p) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		session.saveOrUpdate(p);
		tx.commit();

	}

	public void deletePatient(int id) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		session.delete(session.get(Patient.class, id));

		tx.commit();

	}

}

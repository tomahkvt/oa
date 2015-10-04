package org.oa.ajax_rest_demo.dao;


import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.oa.ajax_rest_demo.model.Animal;

import java.util.List;

public class AnimalRepository {

	private final SessionFactory sessionFactory;

	public AnimalRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(Animal item) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
	}

	public void update(Animal item) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(item);
		session.getTransaction().commit();
	}

	public void delete(Animal item) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(item);
		session.getTransaction().commit();
	}

	public List<Animal> findAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("FROM Animal");
		List<Animal> result = query.list();

		session.getTransaction().commit();
		return result;
	}
}

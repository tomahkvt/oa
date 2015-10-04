package org.oa.ajax_rest_demo.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.oa.ajax_rest_demo.model.Food;

import java.util.List;

public class FoodRepository {

	private final SessionFactory sessionFactory;

	public FoodRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(Food item) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
	}

	public void update(Food item) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(item);
		session.getTransaction().commit();
	}

	public void delete(Food item) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(item);
		session.getTransaction().commit();
	}

	public List<Food> findAll(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("FROM Food WHERE id_animal=" + id);
		List<Food> result = query.list();

		session.getTransaction().commit();
		return result;
	}
}

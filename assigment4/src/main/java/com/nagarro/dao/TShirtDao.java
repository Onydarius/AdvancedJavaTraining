package com.nagarro.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.model.TShirt;
import com.nagarro.util.HibernateUtil;

public class TShirtDao {

	public List<TShirt> getAll() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			List<TShirt> products = session.createQuery("from TShirt", TShirt.class).getResultList();

			// commit transaction
			transaction.commit();
			return products;
		} catch (Exception e) {
			/*
			 * if (transaction != null) { transaction.rollback(); }
			 */
			e.printStackTrace();
		}
		return null;
	}

	public TShirt getById(String id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			TShirt tShirt = session.get(TShirt.class, id);

			// commit transaction
			transaction.commit();
			return tShirt;
		} catch (Exception e) {
			/*
			 * if (transaction != null) { transaction.rollback(); }
			 */
			e.printStackTrace();
		}
		return null;
	}

	public int save(TShirt tShirt) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			session.save(tShirt);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			/*
			 * if (transaction != null) { transaction.rollback(); }
			 */
			e.printStackTrace();
			return 0;
		}

		return 1;
	}

	public boolean deleteById(String id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			session.delete(this.getById(id));
			;
			// commit transaction
			transaction.commit();
			return true;
		} catch (Exception e) {
			/*
			 * if (transaction != null) { transaction.rollback(); }
			 */
			e.printStackTrace();
		}

		return false;
	}

	public void update(TShirt tShirt) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			session.update(tShirt);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			/*
			 * if (transaction != null) { transaction.rollback(); }
			 */
			e.printStackTrace();
		}
	}

	public List<TShirt> search(String colour, String size, String gender, String outputPreference) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			String sql = "FROM TShirt WHERE colour = '" + colour + "' AND size = '" + size
					+ "'  AND GENDER_RECOMMENDATION = '" + gender + "' AND availability = 'Y' ORDER BY ";

			if (outputPreference.trim().equalsIgnoreCase("price")) {
				sql += "price ASC";
			}

			if (outputPreference.trim().equalsIgnoreCase("rating")) {
				sql += "rating DESC";
			}
			if (outputPreference.trim().equalsIgnoreCase("Price and rating")) {
				sql += "price ASC, rating DESC";
			}

			List<TShirt> query = session.createQuery(sql, TShirt.class).getResultList();

			// commit transaction
			transaction.commit();

			return query;
		} catch (Exception e) {
			/*
			 * if (transaction != null) { transaction.rollback(); }
			 */
			e.printStackTrace();
		}
		return null;
	}

}

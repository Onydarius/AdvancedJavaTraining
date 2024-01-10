package com.nagarro.javaTraining.assigment2.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.javaTraining.assigment2.model.TShirt;
import com.nagarro.javaTraining.assigment2.util.HibernateUtil;

public class TshirtDao {
	public void saveStudent(TShirt tshirt) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(tshirt);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
 				transaction.rollback();
			}
			System.out.println("an error has ocurred in the database: " + e.getMessage());
		}
	}


	public List<TShirt> searchByParameters(String color, String size, String gender, String outputPreference) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			String sql = "FROM TShirt WHERE colour = '" + color + "' AND size = '" + size
					+ "' AND GENDER_RECOMMENDATION = '" + gender + "'AND availability = 'Y' ORDER BY ";

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
			if (transaction != null) {
 				transaction.rollback();
			}
			System.out.println("an error has ocurred in the database: " + e.getMessage());
		}
		return null;
	}
}

package com.webserv.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.webserv.model.Product;
import com.webserv.repository.ProductRepository;
import com.webserv.util.HibernateUtil;

public class ProductDao implements ProductRepository {

	@Override
	public List<Product> getAll() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			
			
			
			List<Product> products = session.createQuery("from Product", Product.class).getResultList();

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

	@Override
	public Product getById(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			Product product = session.get(Product.class, id);

			// commit transaction
			transaction.commit();
			return product;
		} catch (Exception e) {
			/*
			 * if (transaction != null) { transaction.rollback(); }
			 */
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int save(Product product) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			session.save(product);

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

	@Override
	public boolean deleteById(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			 session.delete(this.getById(id));;
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

	public void update(Product product) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			session.update(product);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			/*
			 * if (transaction != null) { transaction.rollback(); }
			 */
			e.printStackTrace();
		}		
	}

}

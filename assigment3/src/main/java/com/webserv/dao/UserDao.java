package com.webserv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.webserv.model.User;
import com.webserv.repository.UserRepository;
import com.webserv.util.HibernateUtil;

public class UserDao implements UserRepository{

	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	
	@Override
	public int checkuser(User user) {
        Transaction transaction = null;

		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            
	            String sql ="FROM User where username = '" + user.getUsername() + "' and password = '" + user.getPassword()+ "'";
	            
	            
	            // get an user object
	            List<User> query = session.createQuery(sql,User.class).getResultList();
	            	           	            
	            if(query.size() >= 1) {
	            	return 1;
	            }
	            
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
				/*
				 * if (transaction != null) { transaction.rollback(); }
				 */
	            e.printStackTrace();
	        }
		 
		 return 0;
	
	}


	@Override
	public int saveUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            
            
            session.save(user);
            
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
			/*
			 * if (transaction != null) { transaction.rollback(); }
			 */
            e.printStackTrace();
        }
	 
	 return 1;
	}

}

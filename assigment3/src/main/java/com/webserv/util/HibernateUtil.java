package com.webserv.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.webserv.dao.UserDao;
import com.webserv.model.Product;
import com.webserv.model.User;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration().configure();

				
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Product.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				System.out.println("Hibernate Java Config serviceRegistry created");
				
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                
                
//                User user = new User();
//                user.setUsername("admin");
//                user.setPassword("root");
//                
//                UserDao us = new UserDao();
//                us.saveUser(user);
                
                return sessionFactory;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

}

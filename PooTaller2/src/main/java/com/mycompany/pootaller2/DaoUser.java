/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pootaller2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author PRIME
 */
public class DaoUser {
    protected SessionFactory sessionFactory;
	
	protected void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()  //lee los settings del archivo hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry)
					.buildMetadata().buildSessionFactory();			
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		
	}
	
	protected void crear(User user) {
		Session s =  sessionFactory.openSession();
		s.beginTransaction();
		s.save(user);
		s.getTransaction().commit();
		s.close();
	}
        
        protected User read(int userID) {
		Session s =  sessionFactory.openSession();
		User user = s.get(User.class, userID);
		s.close();
		return user;
	}
	
	protected void update(User user) {
		Session s =  sessionFactory.openSession();
		s.beginTransaction();
		s.update(user);
		s.getTransaction().commit();
		s.close();
	}
	
	
	protected void delete(int userID) {
		Session s =  sessionFactory.openSession();
		s.beginTransaction();
		User user = new User();
		user.setId(userID);
		s.delete(user);
		s.getTransaction().commit();
		s.close();
       }
}

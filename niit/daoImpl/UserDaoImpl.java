package com.niit.daoImpl;

import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDAO;
import com.niit.model.User;

import ch.qos.logback.classic.Logger;
@Repository(value="userDAO")
public class UserDaoImpl implements UserDAO {
	
	private static final Logger log=(Logger) LoggerFactory.getLogger(UserDaoImpl.class);
	
      @Autowired
         SessionFactory sessionFactory;
      
      public UserDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

      
      @Transactional
	public boolean save(User user) {
    	  log.debug("CAlling of the method save");
		try{	
		sessionFactory.getCurrentSession().save(user);
		return true;
	}catch(HibernateException e){
		e.printStackTrace();
		return false;
	}
	}

      @Transactional
	public boolean update(User user) {
    	  log.debug("CAlling of the method update");

		try{	
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

      @Transactional
	public User get(String userId) {
    	  log.debug("CAlling of the method get");
          log.debug("UserId=" +userId);
		return	(User) sessionFactory.getCurrentSession().get(User.class, userId);
		 
	}

      @Transactional
	public User validate(String userId, String password) {
    	  log.debug("CAlling of the method validate");
    	  //for security purpose we shouldn't print password
    	  //below line should be removed at deploying time
    	   log.debug("UserId=" +userId + "password=" +password);
		String hql="from User where userId='"+userId+"'and password='"+password+"'";
		Query query= sessionFactory.getCurrentSession().createQuery(hql);
		return (User) query.uniqueResult();
	}

      @Transactional
	public List<User> getAllUsers() {
    	  log.debug("CAlling of the method getAllUsers");

		String hql="from User";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}

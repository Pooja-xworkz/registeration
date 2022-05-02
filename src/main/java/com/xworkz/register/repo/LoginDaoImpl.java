package com.xworkz.register.repo;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.register.entity.LoginEntity;
import com.xworkz.register.entity.RegisterationEntity;


@Component
public class LoginDaoImpl implements  LoginDao{
	private static final Logger logger = Logger.getLogger(RegisterationDaoImpl.class);
	@Autowired
	private SessionFactory factory;
	
	LoginDaoImpl(){
		logger.info("created " + this.getClass().getSimpleName());
	}

	@Override
	public String validateUser(String email) {
		Transaction tr = null;
		Session session = null;
		try {
			System.out.println("calling email");
			session = factory.openSession();
			Query query = session.createQuery("select dto from RegisterationEntity dto  where dto.email = '" +  email + "'");
			RegisterationEntity entities =  (RegisterationEntity) query.uniqueResult();
			System.out.println(entities.getEmail());
			return entities.getEmail();
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return null;
	}



@Override
public RegisterationEntity validateOtp(String Otp) {
	Transaction tr = null;
	Session session = null;
	RegisterationEntity obj=null;
	try {
		System.out.println("calling otp");
		session = factory.openSession();
		Query query = session.createQuery("select dto from RegisterationEntity dto  where dto.otp = '" +  Otp + "'");
		Object entities = query.getSingleResult();
		obj=(RegisterationEntity)entities;
		if(obj!=null) {
			
			System.out.println(obj.getOtp());
			return obj;
		}
		
	} catch (Exception e) {

	} finally {
		session.close();
	}
	return obj;
	
	
	
}
@Override
public RegisterationEntity userExist(String email) {
	Transaction tr = null;
	Session session = null;
	RegisterationEntity entities = null;
	
	try {
		System.out.println("calling email");
		session = factory.openSession();
		Query query = session.createQuery("select dto from RegisterationEntity dto  where dto.email = '" +  email + "'");
		 Object entity =  query.uniqueResult();
		 if(entity!=null) {
			 entities= (RegisterationEntity) entity;
			 System.out.println(entities);
			 return entities;
			
		 }
		
	} catch (Exception e) {

	} finally {
		session.close();
	}
	return entities;
	
	
}
}

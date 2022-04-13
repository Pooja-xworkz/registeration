package com.xworkz.register.repo;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.register.entity.RegisterationEntity;

@Component
public class RegisterationDaoImpl implements RegisterationDao {
	private static final Logger logger = Logger.getLogger(RegisterationDaoImpl.class);

	@Autowired
	private SessionFactory factory;

	RegisterationDaoImpl() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	@Override
	public void register(RegisterationEntity regEntity) {
		Transaction tr = null;
		Session session = null;
		try {
			session = factory.openSession();
			tr = session.beginTransaction();
			session.save(regEntity);
			tr.commit();
		} catch (HibernateException e) {
			tr.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}

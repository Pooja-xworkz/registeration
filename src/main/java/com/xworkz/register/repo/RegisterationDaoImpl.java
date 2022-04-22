package com.xworkz.register.repo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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

	@Override
	public List<RegisterationEntity> findByEmail(String email) {

		Transaction tr = null;
		Session session = null;
		List<RegisterationEntity> entities = new ArrayList<RegisterationEntity>();
		try {
			System.out.println("calling email");
			session = factory.openSession();
			Query query = session.createQuery("select dto from RegisterationEntity dto  where dto.email = '" + email + "'");
			entities = query.list();
			System.out.println(entities.size());
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return entities;
	}

}

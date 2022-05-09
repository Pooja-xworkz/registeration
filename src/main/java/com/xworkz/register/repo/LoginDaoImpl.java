package com.xworkz.register.repo;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.xworkz.register.entity.RegisterationEntity;

@Component
public class LoginDaoImpl implements LoginDao {
	private static final Logger logger = Logger.getLogger(RegisterationDaoImpl.class);
	@Autowired
	private SessionFactory factory;

	LoginDaoImpl() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	@Override
	public RegisterationEntity validateUser(String email) {
		Transaction tr = null;
		Session session = null;
		try {
			System.out.println("calling email");
			session = factory.openSession();
			// tr = session.beginTransaction();
			TypedQuery query = session.getNamedQuery("findByEmail");
			query.setParameter("email", email);
			RegisterationEntity lst = (RegisterationEntity) query.getSingleResult();
			System.out.println(lst.getEmail());
			return lst;
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return null;
	}

	public int updateotp(String otp, String email) {
		Transaction tr = null;
		Session session = null;
		try {
			System.out.println("calling update method");
			session = factory.openSession();
			tr = session.beginTransaction();
			TypedQuery query = session.getNamedQuery("updateByEmail");
			query.setParameter("otp", otp);
			query.setParameter("email", email);
			System.out.println(query.executeUpdate());
			int update = query.executeUpdate();
			System.out.println(update);
			tr.commit();
			return update;
		} catch (Exception e) {
			logger.error(e);
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public RegisterationEntity validateOtp(String Otp) {
		Transaction tr = null;
		Session session = null;
		RegisterationEntity obj = null;
		try {
			System.out.println("calling otp");
			session = factory.openSession();
			Query query = session.createQuery("select dto from RegisterationEntity dto  where dto.otp = '" + Otp + "'");
			Object entities = query.getSingleResult();
			obj = (RegisterationEntity) entities;
			if (obj != null) {

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
			System.out.println("calling success for email ");
			session = factory.openSession();
			TypedQuery query = session.getNamedQuery("findByEmail");
			query.setParameter("email", email);
			entities = (RegisterationEntity) query.getSingleResult();
			
				System.out.println(entities.getEmail());
				return entities;

			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return entities;

	}

	public int update(RegisterationEntity entity) {
		Transaction tr = null;
		Session session = null;

		try {
			System.out.println("calling success for edit ");
			session = factory.openSession();
			tr = session.beginTransaction();
			TypedQuery query = session.getNamedQuery("updateAllDataByEmail");

			query.setParameter("name", entity.getName());
			query.setParameter("surName", entity.getSurName());
			query.setParameter("address", entity.getAddress());
			query.setParameter("phoneNo", entity.getPhoneNo());
			query.setParameter("zip", entity.getZip());
			query.setParameter("dateOfBirth", entity.getDateOfBirth());
			query.setParameter("email", entity.getEmail());
			int update = query.executeUpdate();
			tr.commit();
			System.out.println(update);
			return update;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public List<RegisterationEntity> findByName(String name) {
		Transaction tr = null;
		Session session = null;
		List<RegisterationEntity> entities = null;

		try {
			System.out.println("calling success for name ");
			session = factory.openSession();
			TypedQuery query = session.getNamedQuery("findByName");
			query.setParameter("name", name);
			entities=query.getResultList();
			System.out.println(entities.size());
             return entities;
		} catch (Exception e) {
			logger.debug(e);
		} finally {
			session.close();
		}
		return entities;

	}
}

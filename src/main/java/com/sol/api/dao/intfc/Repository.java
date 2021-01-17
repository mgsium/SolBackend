package com.sol.api.dao.intfc;

import org.hibernate.Transaction;

import com.sol.api.hibernate.HibernateSessionHandler;

import java.util.Optional;

import org.hibernate.Session;

public abstract class Repository<T, IdType> implements RepositoryInterface<T, IdType> {
	
	@Override
	public boolean insertObject(T object) {
		Transaction tx = null;
		try(Session session = HibernateSessionHandler.getHibernateSession()) {
			tx = session.beginTransaction();
			session.save(object);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) tx.rollback();
			return false;
		}
	}
	
	@Override
	public Optional<T> retrieveObject(IdType id, Class<T> entityClass) {
		try(Session session = HibernateSessionHandler.getHibernateSession()) {
			T object = session.find(entityClass, id);
			return Optional.ofNullable(object);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return Optional.ofNullable(null);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean updateObject(Object object) {
		Transaction tx = null;
		try(Session session = HibernateSessionHandler.getHibernateSession()) {
			tx = session.beginTransaction();
			T objectMerged = (T) session.merge(object);
			session.saveOrUpdate(objectMerged);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deleteObject(IdType id, Class<T> entityClass) {
		Transaction tx = null;
		try(Session session = HibernateSessionHandler.getHibernateSession()) {
			tx = session.beginTransaction();
			T object = session.find(entityClass, id);
			session.delete(object);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}

package com.sol.api.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchService {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	public SearchService(EntityManagerFactory entityManagerFactory) {
		super();
		this.entityManager = entityManagerFactory.createEntityManager();
	}
	
	/**
	 * Initialize Index
	 */
	public void initializeHibernateSearch() {
		try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

}

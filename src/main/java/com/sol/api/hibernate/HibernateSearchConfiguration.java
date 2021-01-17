package com.sol.api.hibernate;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class HibernateSearchConfiguration {

	private EntityManagerFactory entityManagerFactory;

    @Autowired
    public HibernateSearchConfiguration(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    /**
     * Initializes a hibernate SearchService object.
     * @return SearchService instance.
     */
    @Bean
    SearchService hibernateSearchService() {
        SearchService hibernateSearchService = new SearchService(this.entityManagerFactory);
        hibernateSearchService.initializeHibernateSearch();
        return hibernateSearchService;
    }
    
}

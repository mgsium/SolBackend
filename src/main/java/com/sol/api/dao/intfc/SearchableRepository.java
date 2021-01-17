package com.sol.api.dao.intfc;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.SearchFactory;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.sol.api.hibernate.HibernateSessionHandler;
import com.sol.api.model.Lesson;

public abstract class SearchableRepository<T, IdType> extends Repository<T, IdType> implements Searchable<T, IdType> {
	
	@SuppressWarnings("unchecked")
	public List<Lesson> searchForLessons(String searchString, String targetFieldName, Class<T> entityClass) {
		try(Session session = HibernateSessionHandler.getHibernateSession()) {
			// Get Full Text Session
			FullTextSession fullTextSession = Search.getFullTextSession(session);
			// Get Query Builder
			SearchFactory searchFactory = fullTextSession.getSearchFactory();
			QueryBuilder queryBuilder = searchFactory.buildQueryBuilder().forEntity(entityClass).get();
			// Build Query
			// TODO: Optimise search for greater accuracy
			Query luceneQuery = buildQuery(queryBuilder, targetFieldName, searchString);
			// Execute Query
			List<Lesson> lessons = fullTextSession.createFullTextQuery(luceneQuery).list();
			return lessons;
		}
	}
	
	@Override
	public List<T> getRandomRecords(int maxResults, Class<T> entityClass) {
		try(Session session = HibernateSessionHandler.getHibernateSession()) {
			String hql = "SELECT l FROM Lesson l ORDER BY rand()";
			org.hibernate.query.Query<T> query = session.createQuery(hql, entityClass).setMaxResults(maxResults);
			List<T> entities = query.getResultList();
			session.close();
			return entities;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	private Query buildQuery(QueryBuilder queryBuilder, String targetFieldName, String searchString) {
		return queryBuilder
				.keyword()
				.fuzzy()
				.onField(targetFieldName)
				.matching(searchString)
				.createQuery();
	}
	
}

package com.sol.api.dao.intfc;

import java.util.List;

import com.sol.api.model.Lesson;

public interface Searchable<T, IdType> {

	List<Lesson> searchForLessons(String searchString, String targetFieldName, Class<T> entityClass);
	
	List<T> getRandomRecords(int maxResults, Class<T> entityClass);
	
}

package com.sol.api.dao.intfc;

import java.util.Optional;

public interface RepositoryInterface<T, IdType> {
	boolean insertObject(T object);
	
	Optional<T> retrieveObject(IdType id, Class<T> entityClass);
	
	boolean updateObject(T object);
	
	boolean deleteObject(IdType id, Class<T> entityClass);
}

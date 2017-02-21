package ro.bydl.dao;

import java.util.Collection;

import ro.bydl.domain.AbstractModel;
/**
 * This interface gives the basic layout of a DB teamplate
 * @author Raul
 *
 * @param <T>
 */


public interface BaseDao<T extends AbstractModel> {

	Collection<T> getAll();
	
	T findById(long id);
	
	long insert(T model);
	
	int delete(T model);

	T update(T model);

	


}


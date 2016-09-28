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
	
	T findById(Long id);
	
	T update(T model);
	
	int delete(T model);

	int edit(T model);


}


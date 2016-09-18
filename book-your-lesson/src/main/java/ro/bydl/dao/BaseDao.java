package ro.bydl.dao;

import java.util.Collection;

import ro.bydl.domain.AbstractModel;
import ro.bydl.domain.Schedule;



public interface BaseDao<T extends AbstractModel> {

	Collection<T> getAll();
	
	T findById(Long id);
	
	int update(T model);
	
	int delete(T model);
}


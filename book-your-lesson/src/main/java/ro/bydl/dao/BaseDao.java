package ro.bydl.dao;

import java.util.Collection;

import ro.bydl.domain.AbstractModel;
import ro.bydl.domain.Schedule;
import ro.bydl.domain.Student;
import ro.bydl.domain.Teacher;
import ro.bydl.domain.Vehicle;



public interface BaseDao<T extends AbstractModel> {

	Collection<T> getAll();
	
	T findById(Long id);
	
	T update(T model);
	
	int delete(T model);

	int edit(T model);
}


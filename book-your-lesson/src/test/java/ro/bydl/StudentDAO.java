package ro.bydl;

import java.util.Collection;

import ro.bydl.domain.Student;

public interface StudentDAO<T> {
Collection<T> getAll();
	
	T findById(Long id);
	
	T update(T model);
	
	int delete(T model);

	int edit(T model);
	Collection<Student> getByTeacher(long id);


}

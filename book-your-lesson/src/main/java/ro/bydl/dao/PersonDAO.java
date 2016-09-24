package ro.bydl.dao;

import java.util.Collection;

import ro.bydl.domain.Person;
import ro.bydl.domain.Student;



public interface PersonDAO extends BaseDao <Student>  {

	Collection<Student> getByTeacher(int theacherId);
	

	

}

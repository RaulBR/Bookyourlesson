package ro.bydl.dao;

import java.util.Collection;

import ro.bydl.domain.Student;
/**
 * This interface is the specific methos for a student DB
 * @author Raul
 *
 */


public interface StudnetDAO extends BaseDao <Student>  {

	Collection<Student> getByTeacher(long id);

	

}

package ro.bydl;

import java.util.Collection;

import ro.bydl.dao.BaseDao;
import ro.bydl.domain.Student;

public interface StudentDAO extends BaseDao<Student> {

	Collection<Student> getByTeacher(long id);

}

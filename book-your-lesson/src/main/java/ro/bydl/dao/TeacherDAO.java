package ro.bydl.dao;

import java.util.Collection;

import ro.bydl.domain.Teacher;

public interface TeacherDAO extends BaseDao<Teacher> {

	Teacher findByCnp(String cnp);

	Teacher findByEmail(String email);

	long find(String find);

	Collection<Teacher> findByIncompletName(String value);
}

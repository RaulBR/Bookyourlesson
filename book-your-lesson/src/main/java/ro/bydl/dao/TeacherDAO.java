package ro.bydl.dao;

import java.util.Collection;

import ro.bydl.domain.Teacher;

public  interface TeacherDAO extends BaseDao<Teacher>{
	Collection<Teacher> getByTeacher(int theacherId);
}

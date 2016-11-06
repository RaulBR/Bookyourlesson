package ro.bydl.service;

import java.util.Calendar;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.TeacherDAO;
import ro.bydl.domain.Teacher;
@Service

public class TeacherService extends PersonHelper {

	@Autowired
	private TeacherDAO dao;

	
	public Teacher findById(long id) {
		
		return dao.findById(id);
	}
	public long addTeacher(Teacher teacher) {
		
		setHireDate(teacher);
		refinePerson(teacher);
		return dao.insert(teacher);
	}
	private void setHireDate(Teacher teacher) {
		Calendar cal = Calendar.getInstance();
		
		teacher.setHireDate((cal.getTime()));
	}
	public Collection <Teacher> getAll() {
		
		return dao.getAll();
	}

}

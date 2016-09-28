package ro.bydl.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.database.JdbcTeamplateTeacherDAO;
import ro.bydl.domain.Teacher;
@Service
public class TeacherService extends PersonService {

	@Autowired
	JdbcTeamplateTeacherDAO dao;
	
	public Teacher findById(long id) {
		
		return dao.findById(id);
	}
	public Teacher addTeacher(Teacher teacher) {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		
		teacher.setHireDate(dateFormat.format(cal.getTime()));
		return dao.update(teacher);
	}
	public Collection <Teacher> getAll() {
		
		return dao.getAll();
	}

}
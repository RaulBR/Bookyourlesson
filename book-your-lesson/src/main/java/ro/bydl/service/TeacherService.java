package ro.bydl.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.database.jdbcTeamplateTeacherDAO;
import ro.bydl.domain.Teacher;
@Service
public class TeacherService extends PersonService {

	@Autowired
	jdbcTeamplateTeacherDAO dao;
	
	public Teacher getByid(int id) {
		
		return dao.findById((long) id);
	}
	public Teacher addTeacher(Teacher teacher) {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		
		teacher.setHireDate(dateFormat.format(cal.getTime()));
		return dao.update(teacher);
	}

}
